package LoginCourier;

import Courier.CourierApi;
import Courier.LoginCredentials;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

public class TestLoginCourierNotLoginError {
    private CourierApi courierApi;
    private Response response;

    @Test
    @DisplayName("если нет поля login, запрос возвращает ошибку")
    public void toLoginCourierNotLoginError () {
        courierApi = new CourierApi();
        LoginCredentials loginCredentials = LoginCredentials.builder()
                .password(RandomStringUtils.randomAlphabetic(10))
                .build();
        response = courierApi.loginResp(loginCredentials);
        response.then().assertThat().body("message", equalTo("Недостаточно данных для входа"));

    }
}