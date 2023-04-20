import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SwaggerPetstore {
    @Test
    void createUser() { // post request
        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 101,\n" +
                        "  \"username\": \"Tony32\",\n" +
                        "  \"firstName\": \"Tony\",\n" +
                        "  \"lastName\": \"Stark\",\n" +
                        "  \"email\": \"Tony321@gmail.com\",\n" +
                        "  \"password\": \"stark23\",\n" +
                        "  \"phone\": \"1456985645\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/user");
        response.prettyPrint();  // to print response body
        response.then().statusCode(200); // validation
    }
    @Test
    void userLogin(){
        Response response = given()
                .header("accept", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/login?username=Tony32&password=stark23\n");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    void createListOfUsersWithArray(){
        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("[\n" +
                        "    {\n" +
                        "        \"id\": \"101\",\n" +
                        "        \"username\": \"john98\",\n" +
                        "        \"firstName\": \"john\",\n" +
                        "        \"lastName\": \"snow\",\n" +
                        "        \"email\": \"john98@gmail.com\",\n" +
                        "        \"password\": \"johns12345\",\n" +
                        "        \"phone\": \"1456895698\",\n" +
                        "        \"userStatus\": \"0\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": \"102\",\n" +
                        "        \"username\": \"peter78\",\n" +
                        "        \"firstName\": \"peter\",\n" +
                        "        \"lastName\": \"parker\",\n" +
                        "        \"email\": \"parker23@gmail.com\",\n" +
                        "        \"password\": \"peter45678\",\n" +
                        "        \"phone\": \"1523547856\",\n" +
                        "        \"userStatus\": \"0\"\n" +
                        "    }\n" +
                        "]")
                .when()
                .post("https://petstore.swagger.io/v2/user/createWithArray\n");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    void getUserByUserName(){
        Response response = given()
                .header("accept", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/peter78\n");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    void updatedUser() {
        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 1331,\n" +
                        "  \"username\": \"Tony32\",\n" +
                        "  \"firstName\": \"Tony\",\n" +
                        "  \"lastName\": \"Stark\",\n" +
                        "  \"email\": \"Tony321@gmail.com\",\n" +
                        "  \"password\": \"stark23\",\n" +
                        "  \"phone\": \"1456985645\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/user/101\n");
        response.prettyPrint();  // to print response body
        response.then().statusCode(200); // validation
    }
    @Test
    void returnsPetInventoriesByStatus(){
        Response response = given()
                .header("accept", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory\n");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    void addANewPetToTheStore() {
        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"name\": \"doggu\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"<string>\",\n" +
                        "    \"<string>\"\n" +
                        "  ],\n" +
                        "  \"id\": \"1\",\n" +
                        "  \"category\": {\n" +
                        "    \"id\": \"1\",\n" +
                        "    \"name\": \"grey\"\n" +
                        "  },\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": \"1\",\n" +
                        "      \"name\": \"tall dog\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": \"1\",\n" +
                        "      \"name\": \"doggu\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/pet\n");
        response.prettyPrint();  // to print response body
        response.then().statusCode(200); // validation
    }
    @Test
    void updateAnExistingPet() {
        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"name\": \"doggu\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"<string>\",\n" +
                        "    \"<string>\"\n" +
                        "  ],\n" +
                        "  \"id\": \"1\",\n" +
                        "  \"category\": {\n" +
                        "    \"id\": \"1\",\n" +
                        "    \"name\": \"black\"\n" +
                        "  },\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": \"1\",\n" +
                        "      \"name\": \"tall dog\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": \"1\",\n" +
                        "      \"name\": \"doggu\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();  // to print response body
        response.then().statusCode(200); // validation
    }
    @Test
    void findsPetsByStatus(){
        Response response = given()
                .header("accept", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    void findPetByID(){
        Response response = given()
                .header("accept", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/1");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
