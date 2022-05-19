package CreateCourier;

import Courier.CourierApi;
import Courier.LoginCredentials;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Courier.CourierCredentials;
import static org.junit.Assert.assertEquals;



public class TestCreateCourierSuccessRespStatusCode201 {
    private CourierApi courierApi;
    private int courierId;

    @Before
    public void setUp() {
        courierApi = new CourierApi();
    }

    @After
    public void teardown (){
        courierApi.delete(courierId);
    }


    @Test
    @DisplayName( "Успешный запрос Создать курьера возвращает правильный код ответа statusCode= 201")
    public void createCourierSuccessStatusCode201() {
        CourierCredentials courier = CourierCredentials.getRandom();
        Response response  = courierApi.createResp(courier);
        assertEquals(201, response.getStatusCode());

        LoginCredentials loginCredentials = LoginCredentials.from(courier);
        courierId = courierApi.login(loginCredentials);


    }


}
