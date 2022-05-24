package CreateCourier;

import Courier.CourierApi;
import Courier.CourierCredentials;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Courier.LoginCredentials;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class TestSuccessCreateCourier {
    private int courierId;
    private CourierApi courierApi;

    @Before
    public void setUp() {
        courierApi = new CourierApi();
    }

    @After
    public void teardown() {
        courierApi.delete(courierId);
    }

    @Test
    @DisplayName("Курьера успешно можно создать")
    public void createCourierSuccess() {
        CourierCredentials courier = CourierCredentials.getRandom();
        boolean created = courierApi.create(courier);
        assertTrue(created);

        LoginCredentials loginCredentials = LoginCredentials.from(courier);
        courierId = courierApi.login(loginCredentials);

        assertNotEquals(0, courierId);
    }


}
