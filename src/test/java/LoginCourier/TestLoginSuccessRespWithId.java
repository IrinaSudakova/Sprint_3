package LoginCourier;

import Courier.CourierApi;
import Courier.CourierCredentials;
import Courier.LoginCredentials;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class TestLoginSuccessRespWithId {
    private int courierId;
    private CourierApi courierApi;
    private CourierCredentials courier;
    private Response response;

    @Before
    public void setUp() {
        courierApi = new CourierApi();
        courier = CourierCredentials.getRandom();
        boolean created  = courierApi.create(courier);
        assertTrue(created);
    }
    @After
    public void teardown (){
        courierId =  response.then().extract().body().path("id");
        courierApi.delete(courierId);
    }

    @Test
    @DisplayName( "Успешный запрос при авторизации возвращает id")
    public void toLoginCourierSuccessId() {

        LoginCredentials loginCredentials = LoginCredentials.from(courier);
        response = courierApi.loginResp(loginCredentials);
                response.then()
                .assertThat().body(containsString("id"));


    }
}
