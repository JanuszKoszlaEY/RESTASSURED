package com.configuration;

import com.google.common.collect.ImmutableMap;
import com.utilities.PropertyManager;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.commonData.CommonData.LOG_LEVEL;
import static com.commonData.CommonData.URL;

public class RequestSpec {
	private static RequestSpecBuilder spec;
	private static String ALL = "ALL";
	public static final List<Filter> FILTERS =
			Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter());
	public static final Map<String, String> COMMON_HEADERS =
		ImmutableMap.<String, String>builder()
			.put("accept", "application/json")
			.put("accept-Encoding", "gzip, deflate, br")
			.build();

	public static RequestSpecification get() {
		spec = new RequestSpecBuilder();
		if (LOG_LEVEL.contains(ALL)){
			spec.addFilters(FILTERS);
//			spec.log(LogDetail.ALL);
		}
			spec.setRelaxedHTTPSValidation()
				.setBaseUri(URL)
				.addHeaders(COMMON_HEADERS)
				.setContentType(ContentType.JSON);

		return spec.build();
	}



}
