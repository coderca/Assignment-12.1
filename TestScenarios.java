import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testing.annotations.Test;

public class TestScenarios extends BaseClass{

    Utility util = new Utility()

    @Test
            public void StudentapiPostCall(){
        //post
        String payload = "{\n" +
                "\"branch\" : \"CSE\",\n" +
                "\"id\" : \"1\",\n" +
                "\"name\" : \"tom\",\n" +
                "\"sem\" : \"6\",\n" +
                "\"usn\" : \"12345\",\n" +
                "}";


        Response responsePost = RestAssured.given().header( s:"Content-Type", o:"application/json").body(payload)
                .when().post(s:"https://studentformapp.herokuapp.com/")

        String responsePost = responsePost.getBody().asString();
        System.out.println(responseBody);

        int id = util.getvalueUsingJsonPath(responsePost, "id");
        System.out.println("id of the task is" +id);

    }

    @Test
    public void StudentapiGetCall(){
        String payload = "{\n" +
                "\"content\" : \"learn Restassured\"\n" +
                "}";


        Response responsePost = RestAssured.given().header( s:"Content-Type", o:"application/json").body(payload)
                .when().post(s:"https://studentformapp.herokuapp.com/")

        String responsePost = responsePost.getBody().asString();
        System.out.println(responseBody);

        int id = util.getvalueUsingJsonPath(responsePost, "id");
        System.out.println("id of the task is" +id);



        Response responseGet = RestAssured.given()
                .when().get(s:"https://studentformapp.herokuapp.com/" + id);
        String responseBody2 = responseGet.getBody().asString();
        System.out.println(responseBody2);

    }

    @Test
    public void StudentapiDeleteCall(){
        Response responseDelete = RestAssured.given().when().delete(s: "https://studentformapp.herokuapp.com/5");
        System.out.println(responseDelete.getBody().asString());

    }

    @Test
    public void reqresQueryParamTest(){
        RestAssured.baseURI = "https://regres.in";
        Response response = RestAssured.given().queryParams(s:"page", o:1, ...objects:"name","sam").when().get(s:"api/users");
        response.prettyPrint();
    }

    @Test
    public void StudentapiPathParameter(){
        RestAssured.baseURI = "https://studentformapp.herokuapp.com/";
        Response responseGet = RestAssured.given().pathParams(s:"id",o:1,...objects:"name","sam")
                .when().get(s: "https://studentformapp.herokuapp.com/{id}/{name}");
        responseGet.prettyPrint();


    }
}



