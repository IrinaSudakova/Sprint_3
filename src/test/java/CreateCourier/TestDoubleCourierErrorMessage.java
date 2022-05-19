package CreateCourier;

import Courier.CourierApi;
import Courier.CourierCredentials;
import Courier.LoginCredentials;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class TestDoubleCourierErrorMessage {
    private int courierId;
    private CourierApi courierApi;


    @Before
    public void setUp() {
        courierApi = new CourierApi();
    }

    @After
    public void teardown (){
        courierApi.delete(courierId);
    }

    @Test
    @DisplayName("Если создать пользователя с логином, который уже есть, возвращается ошибка")
    public void createDoubleCourierErrorMessage() {
        CourierCredentials courier = CourierCredentials.getRandom();
        boolean created  = courierApi.create(courier);
        assertTrue(created);
        Response response  = courierApi.createResp(courier);
        response.then().assertThat().body("message", equalTo("Этот логин уже используется. Попробуйте другой."));

        LoginCredentials loginCredentials = LoginCredentials.from(courier);
        courierId = courierApi.login(loginCredentials);

    }

}
