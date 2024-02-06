import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class BookCart {
    public static String baseURI = "https://bookcart.azurewebsites.net/api";
    public static String SecretKey="KqcL7s998JrfFHRP";
    @Test
    void add() {
        JSONObject js=new JSONObject();
        js.put("productid","1");
        js.put("quantity","85");
        ApiUtil.performPostRequest(baseURI, "/ShoppingCart/AddToCart/1/85", SecretKey,js)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void getCartItem() {
        ApiUtil.performGetRequest(baseURI, "/ShoppingCart/1", SecretKey)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void delete() {
        ApiUtil.performDeleteRequest(baseURI, "/ShoppingCart/1", SecretKey)
                .then()
                .statusCode(200)
                .log().all();
    }
}
