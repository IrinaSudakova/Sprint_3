package LoginCourier;

import Courier.CourierApi;
import Courier.LoginCredentials;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

public class TestLoginCourierNotPasswordError {
    private CourierApi courierApi;
    private ValidatableResponse response;

    @Test
    @DisplayName("если нет поля password, запрос возвращает ошибку")
    public void toLoginCourierNotLoginError () {
        courierApi = new CourierApi();
        LoginCredentials loginCredentials = LoginCredentials.builder()
                .login(RandomStringUtils.randomAlphabetic(10))
                .build();
        response = courierApi.loginResp(loginCredentials)
                .then()
                .assertThat()
                .body("message", equalTo("Недостаточно данных для входа"));

    }
}