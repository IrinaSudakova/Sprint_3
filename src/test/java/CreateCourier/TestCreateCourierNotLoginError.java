package CreateCourier;

import Courier.CourierApi;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import Courier.CourierCredentials;
import static org.hamcrest.Matchers.equalTo;


public class TestCreateCourierNotLoginError {

    private CourierApi courierApi;

    @Before
    public void setUp() {
        courierApi = new CourierApi();
    }

        @Test
        @DisplayName( "Если нет обязательного поля Login, запрос \"Создать курьера\" возвращает ошибку \"Недостаточно данных для создания учетной записи\"")
        public void createCourierNotLoginError() {
            CourierCredentials courier = CourierCredentials.builder()
                    .password(RandomStringUtils.randomAlphabetic(10))
                    .firstName(RandomStringUtils.randomAlphabetic(10))
                    .build();
            Response response = courierApi.createResp(courier);
            response.then().assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));
        }
    }

