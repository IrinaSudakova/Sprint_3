package LoginCourier;

import Courier.CourierApi;
import Courier.LoginCredentials;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;


public class TestLoginNoCourierError {

    private CourierApi courierApi;
    private Response response;

    @Test
    @DisplayName( "если авторизоваться под несуществующим пользователем, запрос возвращает ошибку")
    public void toLoginNoCourierError() {
        courierApi = new CourierApi();
        LoginCredentials loginCredentials = new LoginCredentials
                (RandomStringUtils.randomAlphabetic(9),
                RandomStringUtils.randomAlphabetic(9));
        response = courierApi.loginResp(loginCredentials);
        response.then().assertThat().body("message", equalTo("Учетная запись не найдена"));

    }
}
