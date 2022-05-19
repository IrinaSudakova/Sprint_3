package CreateCourier;

import Courier.*;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class TestSuccessNotFirstnameCreateCourier {

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

    @Test
    @DisplayName( "Если отсутствует необязательное поле firstname, курьер создается")
    public void createCourierSuccessNotFirstname() {
        CourierCredentials courier = CourierCredentials.builder()
                .login(RandomStringUtils.randomAlphabetic(10))
                .password(RandomStringUtils.randomAlphabetic(10))
                .build();
        boolean created = courierApi.create(courier);

        LoginCredentials loginCredentials = LoginCredentials.from(courier);
        courierId = courierApi.login(loginCredentials);

        assertTrue(created);
        assertNotEquals(0, courierId);
    }

}
