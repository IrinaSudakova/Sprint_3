package LoginCourier;

import Courier.CourierApi;
import Courier.CourierCredentials;
import Courier.LoginCredentials;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class TestLoginCourierMistakeLoginError {
    private int courierId;
    private CourierApi courierApi;
    private CourierCredentials courier;
    private LoginCredentials loginCredentials;

    @Before
    public void setUp() {
        courierApi = new CourierApi();
        courier = CourierCredentials.getRandom();
        boolean created  = courierApi.create(courier);
        assertTrue(created);
        loginCredentials = LoginCredentials.from(courier);
        courierId = courierApi.login(loginCredentials);
        assertNotEquals(0,courierId);
    }
    @After
    public void teardown (){
        courierApi.delete(courierId);
    }

    @Test
    @DisplayName( "система вернёт ошибку, если неправильно указать логин")
    public void toLoginCourierMistakeLoginError() {

        courier.setLogin(RandomStringUtils.randomAlphabetic(9));
        loginCredentials = LoginCredentials.from(courier);
        ValidatableResponse response = courierApi.loginResp(loginCredentials)
                .then()
                .assertThat()
                .body("message", equalTo("Учетная запись не найдена"));

    }
}
