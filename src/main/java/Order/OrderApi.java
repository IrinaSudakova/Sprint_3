package Order;

import Courier.RestAssuredApi;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class OrderApi extends RestAssuredApi {

    private final static String ORDER = "/orders";
    private final static String LISTORDERS = "/orders?courierId=";
    private final static String TRACK = "/orders/track?t=";
    private final static String TAKEORDER = "/orders/accept/";

    public Response order(CreateOrder createOrder) {
        return given()
                .header("Content-type", "application/json")
                .baseUri(URL)
                .and()
                .body(createOrder)
                .when()
                .post(ORDER);

    }

    public ResponseListOrder listOrders(int courierId) {
        return given()
                .header("Content-type", "application/json")
                .baseUri(URL)
                .get(LISTORDERS + courierId)
                .body().as(ResponseListOrder.class);

    }

    public ResponseOrder getIdOrderofTrack(int trackId) {
        return given()
                .header("Content-type", "application/json")
                .baseUri(URL)
                .get(TRACK + trackId)
                .body().as(ResponseOrder.class);

    }

    public boolean takeOrderCourier(int orderId, int courierId) {
        return given()
                .header("Content-type", "application/json")
                .baseUri(URL)
                .put(TAKEORDER + orderId + "?courierId=" + courierId)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("ok");

    }

}