package CreateCourier;

import Courier.CourierApi;
import Courier.CourierCredentials;
import Courier.LoginCredentials;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestDoubleCourierError {
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

    // Тест
    @Test
    @DisplayName( "Нельзя создать двух одинаковых курьеров")
    public void createDoubleCourierError() {
        CourierCredentials courier = CourierCredentials.getRandom();
        boolean created  = courierApi.create(courier);
        assertTrue(created);
        Response response  = courierApi.createResp(courier);
        assertEquals(409, response.getStatusCode());

        LoginCredentials loginCredentials = LoginCredentials.from(courier);
        courierId = courierApi.login(loginCredentials);

        assertNotEquals(0,courierId);
    }


}
