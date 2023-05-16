package com;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.awaitility.Awaitility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class ThisIsNotepad {




    void notes(){
        /*
        ExclusionStrategy[] exclusionStrategies = new ExclusionStrategy[] {
                new GsonExcludeFieldStrategy(new String[] {"id"},
                        MyPojo.class, AnotherPojo.class, AndAgain.class)
        };

        ObjectMapperConfig config = new ObjectMapperConfig(ObjectMapperType.GSON)
                .gsonObjectMapperFactory(
                        (type, s) -> new GsonBuilder()
                                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                                .setExclusionStrategies(exclusionStrategies)
                                .create());

        ObjectMapper customObjectMapper = new GsonMapper(config.gsonObjectMapperFactory());

        given().spec(new RequestSpecBuilder().setBaseUri("localhost").build())
                .body(new Object(),
                        customObjectMapper)
                .when()
                .post("myUrl")
                .then()
                .assertThat()
                .statusCode(HttpServletResponse.SC_OK);

         */
    }

    void matchers(){
        /*
        when().
                get("/json").
                then().
                body("$", hasItems(1, 2, 3)); // An empty string "" would work as well

         */
    }

void withExample(){
        /*
    given().
            parameters("firstName", "John", "lastName", "Doe").
            when().
            post("/greetXML").
            then().
            body("greeting.firstName", equalTo("John")).
            body("greeting.lastName", equalTo("Doe"));

    or a little shorter:

    with().parameters("firstName", "John", "lastName", "Doe").when().post("/greetXML").then().body("greeting.firstName", equalTo("John"), "greeting.lastName", equalTo("Doe"));


given().parameters("firstName", "John", "lastName", "Doe").when().post("/greetXML").then().body(hasXPath("/greeting/firstName", containsString("Jo")));
         */
    }
    void deserialisationWithGenerics(){
/*
        // Extract
        List<Map<String, Object>> products = get("/products").as(new TypeRef<List<Map<String, Object>>>() {});

// Now you can do validations on the extracted objects:
        assertThat(products, hasSize(2));
        assertThat(products.get(0).get("id"), equalTo(2));
        assertThat(products.get(0).get("name"), equalTo("An ice sculpture"));
        assertThat(products.get(0).get("price"), equalTo(12.5));
        assertThat(products.get(1).get("id"), equalTo(3));
        assertThat(products.get(1).get("name"), equalTo("A blue mouse"));
        assertThat(products.get(1).get("price"), equalTo(25.5));```
 */
    }

}
