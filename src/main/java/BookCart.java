import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class BookCart {
    public static String baseURI = "https://bookcart.azurewebsites.net/api";
    public static String SecretKey="KqcL7s998JrfFHRP";
    @Test(dataProvider = "getexcel",dataProviderClass = Book.class)
    void add(String bookid, String userid ) {
        JSONObject js=new JSONObject();
        js.put("userid",userid);
        js.put("bookid",bookid);
        ApiUtil.performPostRequest(baseURI, "/ShoppingCart/AddToCart/"+userid+"/"+bookid, SecretKey,js)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void getCartItem() {
        ApiUtil.performGetRequest(baseURI, "/ShoppingCart/2", SecretKey)
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
