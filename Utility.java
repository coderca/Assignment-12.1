import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utility {

    public int getvalueUsingJsonPath(Response response,String key){
        JsonPath jp = new JsonPath(response.getBody().asString());
        int id = jp.getInt(key);
        return id;
    }
}
