package Courier;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CourierApi extends RestAssuredApi {

    private final static String REGISTRATION ="/courier";
    private final static String LOGIN= "/courier/login";

    public boolean create(CourierCredentials courierCredentials) {
        return given()
                .header("Content-type", "application/json")
                .baseUri(URL)
                .and()
                .body(courierCredentials)
                .when()
                .post(REGISTRATION)
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .extract()
                .path("ok");

    }

    public Response createResp (CourierCredentials courierCredentials) {
        return given()
                .header("Content-type", "application/json")
                .baseUri(URL)
                .and()
                .body(courierCredentials)
                .when()
                .post(REGISTRATION);


    }
    public int login(LoginCredentials loginCredentials) {
        return given()
                .header("Content-type", "application/json")
                .baseUri(URL)
                .body(loginCredentials)
                .post(LOGIN)
                .then()
                .assertThat()
                .statusCode(200)
                .extract().body()
                .path("id");

    }
    public Response loginResp(LoginCredentials loginCredentials) {
        return given()
                .header("Content-type", "application/json")
                .baseUri(URL)
                .body(loginCredentials)
                .post(LOGIN);

    }
    public void delete(int courierId) {
               given()
                .header("Content-type", "application/json")
                .baseUri(URL)
                .delete(REGISTRATION +'/'+courierId)
                 .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract().body();

    }
}
