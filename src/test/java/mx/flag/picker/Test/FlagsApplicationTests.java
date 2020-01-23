package mx.flag.picker.Test;

import static io.restassured.RestAssured.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class FlagsApplicationTests {

  @Before
  public void init() {
    RestAssured.baseURI = "http://localhost"; // replace as appropriate
    RestAssured.port = 8199;
  }

  @Test
  public void testFlagA() {
    given().
        contentType("application/json").
        when().
        post("/api/continent").
        then().
        statusCode(200);

  }
  
  @Test
  public void testFlagB() {
    given().
        contentType("application/json").
        when().
        post("/api/continent/nia").
        then().
        statusCode(200);

  }
  
  @Test
  public void testFlagC() {
    given().body(" {\n" + 
    		"        \"continent\": \"Asia\",\n" + 
    		"        \"countries\": [\n" + 
    		"            {\n" + 
    		"                \"name\": \"China\",\n" + 
    		"                \"flag\": null\n" + 
    		"            }\n" + 
    		"        ]\n" + 
    		"    }").
        contentType("application/json").
        when().
        post("/api/country/").
        then().
        statusCode(200);

  }

}