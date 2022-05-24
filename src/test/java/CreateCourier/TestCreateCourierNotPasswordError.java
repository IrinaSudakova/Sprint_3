package CreateCourier;

import Courier.CourierApi;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import Courier.CourierCredentials;
import static org.hamcrest.Matchers.equalTo;


public class TestCreateCourierNotPasswordError {
    private CourierApi courierApi;
    @Before
    public void setUp() {
        courierApi = new CourierApi();
    }

    @Test
    @DisplayName( "Если нет обяз поля password, запрос \"Создать курьера\" возвращает ошибку \"Недостаточно данных для создания учетной записи\"")
    public void createCourierNotPasswordError() {
        CourierCredentials courier = CourierCredentials.builder()
                .login(RandomStringUtils.randomAlphabetic(10))
                .firstName(RandomStringUtils.randomAlphabetic(10))
                .build();
        ValidatableResponse response = courierApi.createResp(courier)
                .then()
                .assertThat()
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));

    }
}

