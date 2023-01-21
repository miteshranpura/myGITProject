package restAssured.restAssured;

import static io.restassured.RestAssured.*;

public class myFirstRestAssuredClass {
	
	public static void getResponseBody(){
		 given().queryParam("CUSTOMER_ID","68195")
        .queryParam("PASSWORD","1234!")
        .queryParam("Account_No","1")
        .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
        .body();
	}

	public static void main(String[] args) {
		getResponseBody();

	}

}