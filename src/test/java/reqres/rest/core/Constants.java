package reqres.rest.core;

import io.restassured.http.ContentType;

public interface Constants {

    String APP_BASE_URL = "https://reqres.in/";
    //Integer APP_PORT = 443; //http - 80
    String APP_BASE_PATH = "api";

    ContentType APP_CONTENT_TYPE = ContentType.JSON;

    Long MAX_TIMEOUT = 9000L;
}
