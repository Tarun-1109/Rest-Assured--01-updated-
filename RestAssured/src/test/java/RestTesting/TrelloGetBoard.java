package RestTesting;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class TrelloGetBoard {
	
	//Base URL is common of all the actions 
		public static String baseurl = "https://api.trello.com";
		
		@Test
		public void getBoard()
		{
			//Fetching the baseURl and adding the  rest of the thins need to perform that create board action 
			RestAssured.baseURI = baseurl;
			
			//given : pre-condition (parameters,header,Authorization....etc)
			//when : condition i'm testing ( i've to provide the name // resource(/1/board)
			//then : post-condition (to check the response)
			given()
			.queryParam("key", "5dafa42556bbf928303106b01e812f4f")
			.queryParam("token", "96b48be998f3197e19ba32f5d894c848f4854175756dc2df597e62debc8a5652")
			.header("Content-Type", "application/json")
			
		  .when()
		  .get("1/boards/qTSCcUgN")
		  
		  .then()
		  .assertThat().statusCode(200).contentType(ContentType.JSON)
		  .extract().response();
			
			
		}


}
