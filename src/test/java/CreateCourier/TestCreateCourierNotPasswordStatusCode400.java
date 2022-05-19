package CreateCourier;
import Courier.CourierApi;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import Courier.CourierCredentials;


import static org.junit.Assert.*;

public class TestCreateCourierNotPasswordStatusCode400 {

    private CourierApi courierApi;

    @Before
    public void setUp() {
        courierApi = new CourierApi();
    }

    @Test
    @DisplayName( "Если нет обязательного поля password, запрос Создать курьера возвращает  statusCode= 400")
    public void createCourierNotPasswordStatusCode400() {
        CourierCredentials courier = CourierCredentials.builder()
                .login(RandomStringUtils.randomAlphabetic(10))
                .firstName(RandomStringUtils.randomAlphabetic(10))
                .build();
        Response response = courierApi.createResp(courier);
        assertEquals(400, response.getStatusCode());
    }
}
