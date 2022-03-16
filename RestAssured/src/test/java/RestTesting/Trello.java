package RestTesting;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import java.sql.Timestamp;
 
public class Trello {
	
	//Base URL is common of all the actions 
	public static String baseurl = "https://api.trello.com";
	public static String BoardId;
	
	@Test(priority = 0)
	public void createBoard()
	{
		//Fetching the baseURl and adding the  rest of the thins need to perform that create board action 
		RestAssured.baseURI = baseurl;
		
		//given : pre-condition (parameters,header,Authorization....etc)
		//when : condition i'm testing ( i've to provide the name // resource(/1/board)
		//then : post-condition (to check the response)
		Response store = given()
		.queryParam("name", "Laddu's Board")
		.queryParam("key", "5dafa42556bbf928303106b01e812f4f")
		.queryParam("token", "96b48be998f3197e19ba32f5d894c848f4854175756dc2df597e62debc8a5652")
		.header("Content-Type","application/json")
		
	  .when()
	  .post("/1/boards/")
	  
	  .then()
	  .assertThat().statusCode(200).contentType(ContentType.JSON)
	  .extract().response();
		String jsonresponse = store.asString();
		//i want to convert the response in to json format
		//why do i use jsonpath to convert the string in to a json format
		JsonPath js = new JsonPath(jsonresponse);
		//nw i have to fetch the id
		BoardId = js.get("id");
		System.out.println(jsonresponse);
	}
	
	@Test(priority = 1)
	public void getBoard()
	{
		//Fetching the baseURl and adding the  rest of the thins need to perform that create board action 
		RestAssured.baseURI = baseurl;
		
		//given : pre-condition (parameters,header,Authorization....etc)
		//when : condition i'm testing ( i've to provide the name // resource(/1/board)
		//then : post-condition (to check the response)
		Response store = given()
		.queryParam("key", "5dafa42556bbf928303106b01e812f4f")
		.queryParam("token", "96b48be998f3197e19ba32f5d894c848f4854175756dc2df597e62debc8a5652")
		.header("Content-Type", "application/json")
	
	  .when()
	  .get("/1/boards/"+BoardId)
	  
	  .then()
	  .assertThat().statusCode(200).contentType(ContentType.JSON)
	  .extract().response();
	  String jsonresponse = store.asString();
	  System.out.println(jsonresponse);
	}

	
	@Test(priority = 2)
	public void deleteBoard() throws InterruptedException
	{
		
		Timestamp ts = new Timestamp(3000);
				
				System.out.println("Time Stamp:" + ts.toString());
		
		       System.out.println("Time Stamp in Msec :" + ts.getTime());
		       
		      // Thread.sleep(60000);
		       
		//Fetching the baseURl and adding the  rest of the thins need to perform that create board action 
		RestAssured.baseURI = baseurl;
		
		//given : pre-condition (parameters,header,Authorization....etc)
		//when : condition i'm testing (provide the name // resource(/1/board)
		//then : post-condition (to check the response)
		Response store = given()
		.queryParam("key", "5dafa42556bbf928303106b01e812f4f")
		.queryParam("token", "96b48be998f3197e19ba32f5d894c848f4854175756dc2df597e62debc8a5652")
		.header("Content-Type", "application/json")
		
	  .when()
	  .delete("/1/boards/"+BoardId)
	  
	  .then()
	  .assertThat().statusCode(200).contentType(ContentType.JSON)
	  .extract().response();
	  String jsonresponse = store.asString();
	System.out.println(jsonresponse);
	}
}
