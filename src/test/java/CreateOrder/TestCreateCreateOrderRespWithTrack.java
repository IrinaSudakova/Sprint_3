package CreateOrder;

import Order.CreateOrder;
import Order.OrderApi;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import static org.hamcrest.Matchers.containsString;

@RunWith(Parameterized.class)
public class TestCreateCreateOrderRespWithTrack {



        @Parameterized.Parameters(name = "{index}:  Firstname: {0}, Lastname: {1}")
        public static Iterable<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"Мирина", "Малина", "Московская, 141 ул.", "4", "+78003553535", 5, "2020-06-06", "Комментарий 1",new String[]{"BLACK"}},// в заказе можно указать 1 цвет BLACK
                    {"Грог", "Мира", "Московская, 142 ул.", "4", "+78003553535", 5, "2020-06-06", "Комментарий 2",new String[]{"GRAY"}},// // в заказе можно указать 1 цвет GRAY
                    {"Петров", "Иван", "Московская, 143 ул.", "4", "+78003553535", 5, "2020-06-06", "Комментарий 3",new String[]{"BLACK","GRAY"}}, // в заказе можно указать 2 цвета
                    {"Сидоров", "Майк", "Московская, 144 ул.", "4", "+78003553535", 5, "2020-06-06", "Комментарий 4",new String[]{""}} // можно совсем не указывать цвета
            });
        }

        private String firstName;
        private String lastName;
        private String address;
        private String metroStation;
        private String phone;
        private int rentTime;
        private String deliveryDate;
        private String comment;
        private String[] color;

        public TestCreateCreateOrderRespWithTrack(String firstName, String lastName, String address,
                                                  String metroStation, String phone, int rentTime,
                                                  String deliveryDate, String comment, String[] color ) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.metroStation = metroStation;
            this.phone = phone;
            this.rentTime = rentTime;
            this.deliveryDate = deliveryDate;
            this.comment = comment;
            this.color = color;

        }
    private OrderApi orderApi;
    private Response response;

        @Test
        @DisplayName("Тело ответа на запрос Создать заказ содержит поле track")
        public void respCreateOrderRespWithTrack() {


            orderApi = new OrderApi();

            CreateOrder createOrder = new CreateOrder(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment,color);
            response = orderApi.order(createOrder);
            response.then().assertThat().body(containsString("track"));


        }
    }
