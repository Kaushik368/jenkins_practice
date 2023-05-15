package rest_assured;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class bookAPI {
	public String baseUrl="https://simple-books-api.glitch.me";
	//public static String key = "bc4f5a896dba589efd9137b549e78296";
   // public static String token ="ATTA984d4ebde3acb19987e03f54d6c20aca907713d6e8853536dfeee121b59d7659C5B21F1B";			
	public static String token;
	public static String order;
	
    @Test(priority = 0)
    public void Createuser() {
    	  	 	;
    	//Rest-Assured we work with the below aspect
    	//given:request-contains, body,headers-authorization-content-type, quarry parameter
    	//When: resource / board (this will have only resources)
    	//then: response-assertion - String format -- jsonpath
    	
    	//this is to pass my base url
    	
    	  	// Rest-Assured we work with the below aspect
    			// given : request - contains,body,headers,paramter,queryparameter
    			//when : resources / board this will have only resource
    			//then:  response - assertion
    			
    			//this is to pass my baseURL
    			RestAssured.baseURI = baseUrl;
    			
    			String RequestBody = "{\r\n"
    					+ "   \"clientName\": \"ravi478875\",\r\n"
    					+ "   \"clientEmail\": \"ravi7d887785@example.com\"\r\n"
    					+ "}";
    			// i have to pre-condition
    			
    			Response  response =  given().queryParam("name","Masai")
    			.header("Content-Type","application/json")
    			.body(RequestBody)
    			.when()
    			.post("/api-clients/")
    			.then()
    			.assertThat().statusCode(201).contentType(ContentType.JSON)
    			.extract().response();
    			String jsonresponse = response.asString();
    			System.out.println(jsonresponse);
    			// The Below code will  convert my entire response in the json object
    			JsonPath js = new JsonPath(jsonresponse);
    			
    			// This is to fetch the specific object
    			token = js.get("accessToken");
    			System.out.println(token);
    }
    @Test(priority = 1)
    public void updateBoard() {
    	// Rest-Assured we work with the below aspect
    			// given : request - contains,body,headers,paramter,queryparameter
    			//when : resources / board this will have only resource
    			//then:  response - assertion
    			
    			//this is to pass my baseURL
    			RestAssured.baseURI = baseUrl;
    			
    			String RequestBody = "{\r\n"
    					+ "   \"bookId\": 1,\r\n"
    					+ "   \"customerName\": \"aaaava\"\r\n"
    					+ "}";
    			// i have to pre-condition
    			
    			Response  response =  given()
    			.queryParam("name","Masai")
    			.header("Content-Type","application/json")
    			.header("Authorization",token)
    			.body(RequestBody)
    			.when()
    			.post("/orders")
    			.then()
    			.assertThat().statusCode(201).contentType(ContentType.JSON)
    			.extract().response();
    			String jsonresponse = response.asString();
    			System.out.println(jsonresponse);
    			// The Below code will  convert my entire response in the json object
    			JsonPath js = new JsonPath(jsonresponse);
    			
    			// This is to fetch the specific object
    			order = js.get("orderId");
    			System.out.println(order);
    }
    @Test(priority = 2)
    public void getBoard() {
    	
    	RestAssured.baseURI=baseUrl;
    	
    	Response response = given()
    			.header("Content-Type","application/json")
    			.header("Authorization","Bearer "+token)
                .when()
                .get("/orders/"+order)
                .then()
                .contentType(ContentType.JSON)
                .assertThat().statusCode(200)
            	.extract().response();
    	 String jsonresponse = response.asString();
         System.out.println(jsonresponse);
    }
    @Test(priority = 3)
    public void DeleteBoard() {
    RestAssured.baseURI=baseUrl;
    	
    	Response response = given()
    			
                .header("Content-type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .delete("/orders/"+order)
                .then()
                .assertThat().statusCode(204)
            	.extract().response();
    	 String jsonresponse = response.asString();
         System.out.println(jsonresponse);
    }
}