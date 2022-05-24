package ListOrder;

import Courier.CourierApi;
import Courier.CourierCredentials;
import Courier.LoginCredentials;
import Order.CreateOrder;
import Order.OrderApi;
import Order.ResponseListOrder;
import Order.ResponseOrder;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestListOrders {
    private OrderApi orderApi;
    private Response response;
    private int courierId;
    private CourierApi courierApi;
    private CourierCredentials courier;
    private int orderId;
    private int trackId;
    private int actualID;

    @Before
    public void setUp() {
        courierApi = new CourierApi();
        courier = CourierCredentials.getRandom();
        boolean created = courierApi.create(courier);
        assertTrue(created);
        LoginCredentials loginCredentials = LoginCredentials.from(courier);
        courierId = courierApi.login(loginCredentials);

        orderApi = new OrderApi();
        CreateOrder createOrder = new CreateOrder("Грог", "Мира", "Московская, 142 ул.", "4", "+78003553535", 5, "2020-06-06", "Комментарий 2", new String[]{"GRAY"});
        response = orderApi.order(createOrder);
        trackId = response.getBody().path("track");

        ResponseOrder responseOrder = new ResponseOrder();
        responseOrder = orderApi.getIdOrderofTrack(trackId);
        orderId = responseOrder.getOrder().getId();
        boolean takeOrderCourier = orderApi.takeOrderCourier(orderId, courierId);
        assertTrue(takeOrderCourier);

    }

    @Test
    @DisplayName("В тело ответа (заказы курьера) возвращается список заказов.")
    public void respListOrders() {

        orderApi = new OrderApi();
        ResponseListOrder responseListOrder = new ResponseListOrder();
        responseListOrder  = orderApi.listOrders(courierId);
        actualID = responseListOrder.getOrders().get(0).getId();
        assertEquals(orderId,actualID );

    }
}
