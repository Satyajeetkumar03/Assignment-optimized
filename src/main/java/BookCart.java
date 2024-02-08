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
    @Test
    void getbooks() {
//        Response response= (Response) APIUtil.performGetRequest(baseURI,"/Book/",SecretKey);
//        response.then().body("[0].author", equalTo("JKR"));

        Response response = RestAssured.get("https://bookcart.azurewebsites.net/api/Book/2");
        String responseBody = response.getBody().asString();
        String author1 = JsonPath.from(responseBody).getString("author");
        String price1=JsonPath.from(responseBody).getString("price");
        String category1=JsonPath.from(responseBody).getString("category");
        String title1=JsonPath.from(responseBody).getString("title");
        Assert.assertEquals(title1, "HP2");
        Assert.assertEquals(price1, "235.0");
        Assert.assertEquals(category1, "Mystery");
        Assert.assertEquals(author1, "JKR");
    }
}

