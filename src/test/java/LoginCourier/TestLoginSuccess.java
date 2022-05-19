package LoginCourier;

import Courier.CourierApi;
import Courier.CourierCredentials;
import Courier.LoginCredentials;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class TestLoginSuccess {
    private int courierId;
    private CourierApi courierApi;
    private CourierCredentials courier;

    @Before
    public void setUp() {
        courierApi = new CourierApi();
        courier = CourierCredentials.getRandom();
        boolean created  = courierApi.create(courier);
        assertTrue(created);
    }
    @After
    public void teardown (){
        courierApi.delete(courierId);
    }

    @Test
    @DisplayName( "Курьер может успешно авторизоваться")
    public void toLoginCourierSuccess() {

        LoginCredentials loginCredentials = LoginCredentials.from(courier);
        courierId = courierApi.login(loginCredentials);

        assertNotEquals(0,courierId);
    }
}
