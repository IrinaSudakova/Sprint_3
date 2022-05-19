package Courier;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Builder
@Data
public class CourierCredentials {
    // ключ login стал полем типа String
    private String login;
    // ключ password стал полем типа String
    private String password;
    // ключ firstname стал полем типа String
    private String firstName;

    // конструктор со всеми параметрами
    public CourierCredentials(String login, String password, String firstName) {
        this.login = login;
        this.password= password;
        this.firstName= firstName;
    }
    // фабричный метод рандомных значений для создания курьера
    public static  CourierCredentials getRandom(){
        String login = RandomStringUtils.randomAlphabetic(10);
        String password = RandomStringUtils.randomAlphabetic(10);
        String firstName = RandomStringUtils.randomAlphabetic(10);

        return  new CourierCredentials(login, password, firstName);
    }

}
