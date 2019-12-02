package com.SerenityApiDemo.junit.employeeInfo;
import net.thucydides.core.annotations.Title;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.JsonDiff;
import com.github.kvnxiao.jsonequals.JsonRoot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.github.kvnxiao.jsonequals.JsonCompareResult;
import com.github.kvnxiao.jsonequals.JsonEquals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SerenityTestFileResponseTest {
	private static final String ignoreAndPruneA = "C:\\Users\\PALAEM\\Desktop\\SerenityApiDemo\\SerenityApiDemo\\GetAvailablePlans_baseSerenity.txt";
	  private static final String ignoreAndPruneB = "C:\\Users\\PALAEM\\Desktop\\SerenityApiDemo\\SerenityApiDemo\\GetAvailablePlans_testSerenity.txt";
	
	/*
    @Title("Get available plans base response capture")
	@Test
	public void Test01() throws IOException {
	RestAssured.baseURI ="https://c1-k8s-go0v.aws-us-west-2-green.kube-np.ebiz.verizon.com/ev6v";
	 String requestBody= " {\r\n" + 
	 		"  \"data\": {\r\n" + 
	 		"    \"billAccountNum\": \"00001\",\r\n" + 
	 		"    \"customerId\": \"0418191346\",\r\n" + 
	 		"    \"locationCode\": \"0026301\"\r\n" + 
	 		"  },\r\n" + 
	 		"  \"meta\": {\r\n" + 
	 		"    \"clientCorrelationId\": \" \",\r\n" + 
	 		"    \"client\": \"PEGA\",\r\n" + 
	 		"    \"user\": \"gopalvi\"\r\n" + 
	 		"  }\r\n" + 
	 		"}";
	
   Response response=null;

	response=(Response) SerenityRest.given().contentType(ContentType.JSON).when().body(requestBody).post("nsq1/browse/get-available-plans");//serenityrest is only wrapping on restassured
	//the benefits of serenityrest is during the report part
	//then().log().all().statusCode(200);
	BufferedWriter file = null;
	file = new BufferedWriter(
			new FileWriter("C:\\Users\\PALAEM\\Desktop\\SerenityApiDemo\\SerenityApiDemo\\GetAvailablePlans_baseSerenity.txt", true));
	file.write((response.asString()));
	 file.newLine();
     file.close();
	System.out.println("Successfully Copied JSON Object to File...");
	
}
    */
     @Title("Validating available plans response with base response")
	 @Test
		public void Test02a() throws IOException {
			{
				RestAssured.baseURI = "https://c1-k8s-go0v.aws-us-west-2-green.kube-np.ebiz.verizon.com/ev6v";
				String requestBody = " {\r\n" + "  \"data\": {\r\n" + "    \"billAccountNum\": \"00001\",\r\n"
						+ "    \"customerId\": \"0418191346\",\r\n" + "    \"locationCode\": \"0026301\"\r\n" + "  },\r\n"
						+ "  \"meta\": {\r\n" + "    \"clientCorrelationId\": \" \",\r\n" + "    \"client\": \"PEGA\",\r\n"
						+ "    \"user\": \"gopalvi\"\r\n" + "  }\r\n" + "}";
				Response response=null;

				response=(Response) SerenityRest.given().contentType(ContentType.JSON).when().body(requestBody).post("nsq1/browse/get-available-plans");//serenityrest is only wrapping on restassured
				//the benefits of serenityrest is during the report part
				//then().log().all().statusCode(200);
				BufferedWriter file = null;
				file = new BufferedWriter(
						new FileWriter("C:\\Users\\PALAEM\\Desktop\\SerenityApiDemo\\SerenityApiDemo\\GetAvailablePlans_testSerenity.txt", true));
				file.write((response.asString()));
				 file.newLine();
			     file.close();
				System.out.println("Successfully Copied JSON Object to File...");

			
				
			}
	      }
	@Title("Check for the differences in Json Response")
	 @Test
		public void TestWithDifferences() {
			JSONParser parser = new JSONParser();

			try {
				Object object = parser.parse(
						new java.io.FileReader("C:\\Users\\PALAEM\\Desktop\\SerenityApiDemo\\SerenityApiDemo\\GetAvailablePlans_baseSerenity.txt"));
				Object object2 = parser.parse(
						new java.io.FileReader("C:\\Users\\PALAEM\\Desktop\\SerenityApiDemo\\SerenityApiDemo\\GetAvailablePlans_testSerenity.txt"));

				JSONObject jsonobject1 = (JSONObject) object;

				JSONObject jsonobject2 = (JSONObject) object2;

				ObjectMapper mapper = new ObjectMapper();

				JsonNode tree1 = mapper.valueToTree(jsonobject1);

				JsonNode tree2 = mapper.valueToTree(jsonobject2);

				JsonNode patch = JsonDiff.asJson(tree1, tree2);

				String diffs = patch.toString();

				System.out.println("difference" + diffs);
				

			} catch (Exception fe) {

				fe.printStackTrace();

			}

		}
		
	@Title("Ignoring Json attiributes not required for the comparision")
	 
	 @Test
	  public void TestReportWithIgnoreFields04() throws IOException {
	    String rawA = new String(Files.readAllBytes(Paths.get(ignoreAndPruneA)));
	    String rawB = new String(Files.readAllBytes(Paths.get(ignoreAndPruneB)));
	    JsonRoot jsonA = JsonRoot.from(rawA);
	    JsonRoot jsonB = JsonRoot.from(rawB);

	    Set<String> ignoreFields = new HashSet<>();
	    Map<String, String> pruneFields = new HashMap<>();

	    ignoreFields.add("$.meta.timestamp");
	    ignoreFields.add("$.meta.cxpCorrelationId");
	    
//	    pruneFields.put("$.meta.cxpCorrelationId", "false");

	    //JsonCompareResult result = jsonA.compareTo(jsonB, ignoreFields, pruneFields);
	    JsonCompareResult result = jsonA.compareToWithIgnore(jsonB, ignoreFields);
	    result.getInequalityMessages().forEach(System.out::println);

	    assertTrue(result.isEqual());
	  }
	 
	    
}
