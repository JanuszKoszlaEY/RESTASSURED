package com.configuration;

import com.commonData.CommonData;
import com.endpoints.Endpoints;
import com.google.common.collect.ImmutableMap;
import com.utilities.PropertyManager;
import io.restassured.filter.Filter;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RestSpecification {
	private static RequestSpecBuilder spec;

	public static final List<Filter> FILTERS =
			Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter());
	public static final Map<String, String> COMMON_HEADERS =
		ImmutableMap.<String, String>builder()
			.put("accept", "application/json")
			.put("accept-Encoding", "gzip, deflate, br")
			.build();
	public static RequestSpecification get() {
		spec = new RequestSpecBuilder();
		if (PropertyManager.getInstance().getLog().toLowerCase().contains("all")){
			spec.addFilters(FILTERS);
//			spec.log(LogDetail.ALL);
		}
			spec.setRelaxedHTTPSValidation()
				.setBaseUri(PropertyManager.getInstance().getURL())
				.addHeaders(COMMON_HEADERS)
				.setContentType(ContentType.JSON);

		return spec.build();
	}



}
