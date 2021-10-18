import io.restassured.RestAssured;

public class Studentapi {

    public static void main(String[] args){

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



        Response responseGet = RestAssured.given()
                .when().get( s:"https://studentformapp.herokuapp.com/1");

        responseGet.prettyPrint();

        JsonPath jp = new JsonPath(responsePost.getBody().asString());
        int id = jp.getInt(path: "id");

        System.out.println("id of the task is"+id);


        Response responseGetAll = RestAssured.given()
                .when().get( s:"https://studentformapp.herokuapp.com/");
        responseGetAll.prettyPrint();

        Response responseDelete = RestAssured.given().when().delete(s:"https://studentformapp.herokuapp.com/2")
        responseDelete.prettyPrint();



    }
}