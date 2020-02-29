package com.factory.cucumber.stepdefinitions;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.response.Response;

public class HooksDemoTest {
	private final static Logger logger = Logger.getLogger(StepDefinitionsTest.class.getName());
	public static String testName;
	public static String CONTENT_TYPE;
	public static String FILE_PATH;
	public static String REQUESTBODY;
	public static String RESPONSEBODY;
	public static Response response;
	
	@Before
	public void setAPIEndpointURL() {
		String apiHostName = "https://reqres.in";
		StepDefinitionsTest.apiEndPointUri = String.format("%s%s", apiHostName, "/api/users?page=2");
		logger.info("This step runns before All steps of a scenario");
		logger.info("Cucumber Hostname URL is :: " + StepDefinitionsTest.apiEndPointUri);
		logger.info("Cucumber Test case name is :: " + testName);
	}
	
	@After
	public void verifyStatusCode() {
		String statusCode="200";
		if (statusCode.equals(String.valueOf(StepDefinitionsTest.STATUS_CODE))) {
			logger.info("This step runns after All steps of a scenario");
			Assert.assertEquals(StepDefinitionsTest.STATUS_CODE, statusCode);
			logger.info("Status Code is :: " + StepDefinitionsTest.STATUS_CODE);
		} else {
			Assert.assertEquals(StepDefinitionsTest.STATUS_CODE, statusCode);
			logger.info("Status Code is not as expected :: " + StepDefinitionsTest.STATUS_CODE);
		}
	}
	
	@Before(order = 1)
	public void before1() {
		logger.info("Before1 runs in priority order 1");
	}
	
	@Before(order = 2)
	public void before2() {
		logger.info("Before2 runs in priority order 2");
	}
	
	@After(order = 1)
	public void after1() {
		logger.info("After1 runs in priority order 2");
	}
	
	@After(order = 2)
	public void after2() {
		logger.info("After2 runs in priority order 1");
	}
}
