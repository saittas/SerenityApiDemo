package SerenityRestwithMicro;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SerenityMicroFields {
	 
		@Test
		public void Test01a() throws IOException {
			{
				RestAssured.baseURI = "https://c1-k8s-go0v.aws-us-west-2-green.kube-np.ebiz.verizon.com/ev6v";
				String requestBody = " {\r\n" + "  \"data\": {\r\n" + "    \"billAccountNum\": \"00001\",\r\n"
						+ "    \"customerId\": \"0418191346\",\r\n" + "    \"locationCode\": \"0026301\"\r\n" + "  },\r\n"
						+ "  \"meta\": {\r\n" + "    \"clientCorrelationId\": \" \",\r\n" + "    \"client\": \"PEGA\",\r\n"
						+ "    \"user\": \"gopalvi\"\r\n" + "  }\r\n" + "}";
				Response response1 = null;
				try {
					response1 = RestAssured.given().contentType(ContentType.JSON).body(requestBody)
							.post("/nsq1/browse/get-available-plans");
				} catch (Exception e) {
					e.printStackTrace();
				}

				JSONObject obj = new JSONObject();
//		     ObjectMapper mapper = new ObjectMapper();
//		     mapper.writeValue(new File("C:\\Users\\PALAEM\\Desktop\\SerenityApiDemo\\SerenityApiDemo\\json1.txt"), response1 );
//		     
//		     String json = response1.asString();
//		     JSONParser

				BufferedWriter file = null;
				file = new BufferedWriter(
						new FileWriter("C:\\Users\\PALAEM\\Desktop\\RestAssuredDemo\\RestAssuredDemo\\GetAvailablePlans_base.txt", true));
				file.write(response1.asString());
				 file.newLine();
		         file.close();
				System.out.println("Successfully Copied JSON Object to File...");
				System.out.println("\nJSON Object: " + response1);

				System.out.println("Response:" + response1.asString());
				System.out.println("status code:" + response1.getStatusCode());
				System.out.println(
						"Does response contains 'Start Unlimited'?:" + response1.asString().contains("Start Unlimited"));
				assertEquals(200, response1.getStatusCode());
			}
	      }
	    
		//@Ignore
	    @Test
		public void Test02a() throws IOException {
			{
				RestAssured.baseURI = "https://c1-k8s-go0v.aws-us-west-2-green.kube-np.ebiz.verizon.com/ev6v";
				String requestBody = " {\r\n" + "  \"data\": {\r\n" + "    \"billAccountNum\": \"00001\",\r\n"
						+ "    \"customerId\": \"0418191346\",\r\n" + "    \"locationCode\": \"0026301\"\r\n" + "  },\r\n"
						+ "  \"meta\": {\r\n" + "    \"clientCorrelationId\": \" \",\r\n" + "    \"client\": \"PEGA\",\r\n"
						+ "    \"user\": \"gopalvi\"\r\n" + "  }\r\n" + "}";
				Response response1 = null;
				try {
					response1 = RestAssured.given().contentType(ContentType.JSON).body(requestBody)
							.post("/nsq1/browse/get-available-plans");
				} catch (Exception e) {
					e.printStackTrace();
				}

				JSONObject obj = new JSONObject();
//		     ObjectMapper mapper = new ObjectMapper();
//		     mapper.writeValue(new File("C:\\Users\\PALAEM\\Desktop\\SerenityApiDemo\\SerenityApiDemo\\json1.txt"), response1 );
//		     
//		     String json = response1.asString();
//		     JSONParser

				BufferedWriter file = null;
				file = new BufferedWriter(
						new FileWriter("C:\\Users\\PALAEM\\Desktop\\RestAssuredDemo\\RestAssuredDemo\\GetAvailablePlans_test.txt", true));
				file.write(response1.asString());
				 file.newLine();
		         file.close();
				System.out.println("Successfully Copied JSON Object to File...");
				System.out.println("\nJSON Object: " + response1);

				System.out.println("Response:" + response1.asString());
				System.out.println("status code:" + response1.getStatusCode());
				System.out.println(
						"Does response contains 'Start Unlimited'?:" + response1.asString().contains("Start Unlimited"));
				assertEquals(200, response1.getStatusCode());
			}
	      }
	    
	    
	 
		@Test
		public void Test03() {
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
		
		
	}

