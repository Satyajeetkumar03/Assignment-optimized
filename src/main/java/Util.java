import static io.restassured.RestAssured.given;

public class Util {
public static void add(String accessToken,String baseURI){
    given()
            .header("Authorization", "Bearer " + accessToken)
            .when();
}

}
