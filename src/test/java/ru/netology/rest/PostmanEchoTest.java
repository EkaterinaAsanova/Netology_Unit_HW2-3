package ru.netology.rest;


import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    void shouldPostRequest() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .header("Content-Type","application/json; charset=UTF-8")
                .body("Ekaterina") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .header("Content-Type", equalTo("application/json; charset=utf-8"))
                .body("data", equalTo("Ekaterina"))
                ;
    }
}
