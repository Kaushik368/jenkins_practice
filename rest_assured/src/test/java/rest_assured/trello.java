package rest_assured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class trello {
	public static String baseurl="https://api.trello.com/";
	public static String key="0ffdccea3ed9032e6579c39d75a60cb6";
	public static String token="ATTAbfd62fdf54e50daec851326a7b77e05a66322a7e39e883a14d02016116e6a5338011FF57";
	public static String id;
	
	public static String requestBody ="{ \"name\": \"Kaushik\", \"desc\": \"Testing using resAssured\" }";
	public static String requestbody1= "{\r\n"
			+ "    \"name\":\"rahul\" ,         \r\n"
			+ "    \"desc\":\"rahul\"          \r\n"
			+ "}";
	@Test(priority=0)
	public void CreateBoard() {
//		this is to pass baseuri in restasured
		RestAssured.baseURI=baseurl;
//		I have to use pre-conditions
		Response 	response =given().queryParam("name", "ABCD")
		.queryParam("key",key)
		.queryParam("token",token)
		.header("Content-Type","application/json")
		
		.when()
		.post("1/boards/")
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
		String jsonresponse=response.asString();
		System.out.println(jsonresponse);
	  JsonPath js =new JsonPath(jsonresponse);
//		JsonPath js = new JsonPath(jsonresponse);
		id = js.get("id");
	
		
	
	}
	
	@Test(priority=1)
	public void UpdateBoard() {
		
		RestAssured.baseURI=baseurl;
				Response 	response = given()
				
				.queryParam("key",key)
				.queryParam("token",token)
	
				.header("Content-Type","application/json")
                .body(requestbody1)
                .when()
                .put("1/boards/{id}",id)
                .then()
                .assertThat().statusCode(200).contentType(ContentType.JSON)
                .extract().response();
				String jsonresponse=response.asString();
        		System.out.println(jsonresponse);
		
	}
	@Test(priority=2)
    public void getRequest() {
		RestAssured.baseURI=baseurl;
		Response 	response = given()
        	
        		.queryParam("key",key)
				.queryParam("token",token)
		
				.header("Content-Type","application/json")
				
                .contentType(ContentType.JSON)
                .when()
                .get("1/boards/{id}",id)
                .then()
                .assertThat().statusCode(200).contentType(ContentType.JSON)
        		.extract().response();
		String jsonresponse=response.asString();
		System.out.println(jsonresponse);
	}
	 @Test(priority=3)
	    public void deleteRequest() {
		 RestAssured.baseURI=baseurl;
		 Response 	response = given()
	        		.queryParam("key",key)
					.queryParam("token",token)

	                .header("Content-type", "application/json")
	                .when()
	                .delete("1/boards/{id}",id)
	                .then()
	                .assertThat().statusCode(200).contentType(ContentType.JSON)
	                .extract().response();
			 String jsonresponse=response.asString();
				System.out.println(jsonresponse);
	        
	    }
}
