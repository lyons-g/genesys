package com.amazonaws.lambda.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.core.sync.RequestBody;

public class CollegeS3Client {

	protected College getAll() {
		Region region = Region.EU_WEST_1;
        S3Client s3Client = S3Client.builder().region(region).build();
        ResponseInputStream<?> objectData = s3Client.getObject(GetObjectRequest.builder()
        		.bucket("academic-registration")
				.key("registration-data.json")
				.build());
   
 
        College college = new College();
        ObjectMapper mapper = new ObjectMapper();
        
		try { college = mapper.readValue(objectData, College.class);

		}
		catch(JsonParseException e) {
			e.printStackTrace();
		}catch(JsonMappingException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return college;
	}
	
	protected ArrayList<College> getAllList(){
		return new ArrayList<College>(Arrays.asList(getAll()));
	}
	
	
	protected boolean updateAllCollege(College college) {
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(college);
		
		Region region = Region.EU_WEST_1;
        S3Client s3Client = S3Client.builder().region(region).build();
        
        PutObjectResponse putResponse  = s3Client.putObject(PutObjectRequest.builder()
        		.bucket("academic-registration")
				.key("registration-data.json")
				.build(),
        		RequestBody.fromString(jsonString));
		
		return putResponse.sdkHttpResponse().isSuccessful();
	}
	
	/*protected boolean updateAllCollege(List<College> collegeList) {
		College [] college =  (College []) collegeList.toArray(new College[collegeList.size()]);
		return updateAllCollege(college);
		
	}*/
}
