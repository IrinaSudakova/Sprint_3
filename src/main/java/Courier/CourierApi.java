package Courier;

import io.restassured.response.Response;

public class CourierApi extends RestAssuredApi {

    private final static String REGISTRATION = "/courier";
    private final static String LOGIN = "/courier/login";

    public boolean create(CourierCredentials courierCredentials) {
        return reqSpec
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

    public Response createResp(CourierCredentials courierCredentials) {
        return reqSpec
                .and()
                .body(courierCredentials)
                .when()
                .post(REGISTRATION);


    }

    public int login(LoginCredentials loginCredentials) {
        return reqSpec
                .body(loginCredentials)
                .post(LOGIN)
                .then()
                .assertThat()
                .statusCode(200)
                .extract().body()
                .path("id");

    }

    public Response loginResp(LoginCredentials loginCredentials) {
        return reqSpec
                .body(loginCredentials)
                .post(LOGIN);

    }

    public void delete(int courierId) {
        reqSpec
                .delete(REGISTRATION + "/" + courierId)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract().body();

    }
}
