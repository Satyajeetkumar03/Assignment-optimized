import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.*;

public class APITEST2 {
    void testpost() {
//        Response response = get("https://bookcart.azurewebsites.net/api/ShoppingCart/");
//        System.out.println("Status Code :"+response.getStatusCode());
//        System.out.println("Response :"+response.asString());
//        System.out.println("Body :"+response.getBody().asString());
//        System.out.println("Time taken :"+response.getTime());

        baseURI = "https://gorest.co.in";
        String authToken = "b6a35233b6ccd6670029335ffafcbd99dcfa8d80bde9612d1a2c302a2db5297b";
        JSONObject obj = new JSONObject();
//        obj.put("id",0);
        obj.put("name", "Aagam Dutta IV");
        obj.put("email", "aagam_iv_dutta@little-corwin.example");
        obj.put("gender", "male");
        obj.put("status", "active");
        given().header("Authorization", "Bearer " + authToken). // Adding the authentication token
                body(obj.toJSONString()).
                when().
                post("/public/v2/users").

                then().
                statusCode(201)
                .log().all();


    }
    @Test
    void testget() {
//        Response response = get("https://bookcart.azurewebsites.net/api/ShoppingCart/");
//        System.out.println("Status Code :"+response.getStatusCode());
//        System.out.println("Response :"+response.asString());
//        System.out.println("Body :"+response.getBody().asString());
//        System.out.println("Time taken :"+response.getTime());

        baseURI = "https://gorest.co.in";
        String authToken = "b6a35233b6ccd6670029335ffafcbd99dcfa8d80bde9612d1a2c302a2db5297b";
        JSONObject obj = new JSONObject();
        given().header("Authorization", "Bearer " + authToken)
                .body(obj.toJSONString())
                .when()
                .get("/public/v2/users")

                .then()
                .statusCode(200)
                .log().all();


    }
    @Test
    void testdelete() {

        baseURI = "https://gorest.co.in";
        String authToken = "b6a35233b6ccd6670029335ffafcbd99dcfa8d80bde9612d1a2c302a2db5297b";
        JSONObject obj = new JSONObject();
        obj.put("id",6140486);
        obj.put("name", "Mani Nair");
        obj.put("email", "mani_nair@fay.test");
        obj.put("gender", "female");
        obj.put("status", "inactive");
        given().header("Authorization", "Bearer " + authToken)
                .body(obj.toJSONString())
                .when()
                .delete("/public/v2/users/6140486")

                .then()
                .statusCode(204)
                .log().all();


    }
    @Test
    void testget1() {
//        Response response = get("https://bookcart.azurewebsites.net/api/ShoppingCart/");
//        System.out.println("Status Code :"+response.getStatusCode());
//        System.out.println("Response :"+response.asString());
//        System.out.println("Body :"+response.getBody().asString());
//        System.out.println("Time taken :"+response.getTime());

        baseURI = "https://gorest.co.in";
        String authToken = "b6a35233b6ccd6670029335ffafcbd99dcfa8d80bde9612d1a2c302a2db5297b";
        JSONObject obj = new JSONObject();
        given().header("Authorization", "Bearer " + authToken)
                .body(obj.toJSONString())
                .when()
                .get("/public/v2/users/6140486")

                .then()
                .statusCode(404)
                .log().all();


    }

}
