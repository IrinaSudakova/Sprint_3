package Order;

import Courier.RestAssuredApi;
import io.restassured.response.Response;

public class OrderApi extends RestAssuredApi {

    private final static String ORDERS = "/orders/";
    private final static String LISTORDERS = ORDERS;
    private final static String TRACK = ORDERS + "track";
    private final static String TAKEORDER = ORDERS + "accept/{orderId}";

    public Response order(CreateOrder createOrder) {
        return reqSpec
                .and()
                .body(createOrder)
                .when()
                .post(ORDERS);

    }

    public ResponseListOrder listOrders(int courierId) {
        return reqSpec
                .queryParam("courierId", courierId)
                .get(LISTORDERS)
                .body().as(ResponseListOrder.class);

    }

    public ResponseOrder getIdOrderTrack(int trackId) {
        return reqSpec
                .queryParam("t", trackId)
                .get(TRACK)
                .body().as(ResponseOrder.class);

    }

    public boolean takeOrderCourier(int orderId, int courierId) {
        return reqSpec.log().all()
                .pathParam("orderId", orderId)
                .queryParam("courierId", courierId)
                .put(TAKEORDER)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("ok");

    }

}