package com.amazonaws.lambda.demo;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.core.ResponseInputStream;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import java.util.List;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class StudentFindFunction implements RequestHandler<Object, String> {

	@Override
	public String handleRequest(Object input, Context context) {
		context.getLogger().log("Input: " + input);

	

		Region region = Region.EU_WEST_1;
		S3Client s3Client = S3Client.builder().region(region).build();
		
		ResponseInputStream<?>objectData = s3Client.getObject(GetObjectRequest.builder()
				.bucket("academic-registration")
				.key("registration-data.json")
				.build());

		InputStreamReader isr = new InputStreamReader(objectData);
		BufferedReader br = new BufferedReader(isr);
		
		Gson gson = new Gson();
		
		System.out.format("Objects in S3 bucket %s:\n", "academic-registration");
		final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.EU_WEST_1).build();
		ListObjectsV2Result result = s3.listObjectsV2("academic-registration");
		List<S3ObjectSummary> objects = result.getObjectSummaries();
		for (S3ObjectSummary os : objects) {
		    System.out.println("* " + os.getKey());
		}
		return null;

	}

}
