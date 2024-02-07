import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class bookapi {
    String baseURI = "https://bookcart.azurewebsites.net/api";
    String accessToken = "KqcL7s998JrfFHRP";
    @Test
    void Add()
    {
        given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .post(baseURI+"/ShoppingCart/AddToCart/1/85")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    void GetCartItem()
    {
        given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/ShoppingCart/1")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void Delete(){

        given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .delete("/ShoppingCart/1")
                .then()
                .statusCode(200)
                .log().all();
    }
}