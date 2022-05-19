package Courier;

import lombok.Builder;

@Builder
public class LoginCredentials {
    // ключ login стал полем типа String
    private String login;
    // ключ password стал полем типа String
    private String password;

    // конструктор со всеми параметрами
    public LoginCredentials(String login, String password) {
        this.login = login;
        this.password = password;

    }

    public LoginCredentials(CourierCredentials courierCredentials) {
        this.login = courierCredentials.getLogin();
        this.password = courierCredentials.getPassword();
    }

    public static LoginCredentials from (CourierCredentials courierCredentials) {
        return new LoginCredentials (courierCredentials);
    }

    // геттер для поля login
    public String getLogin() {
        return login;
    }

    // сеттер для поля login
    public void setLogin(String login) {
        this.login = login;
    }

    // геттер для поля password
    public String getPassword() {
        return password;
    }

    // сеттер для поля password
    public void setPassword(String password) {
        this.password = password;
    }
}