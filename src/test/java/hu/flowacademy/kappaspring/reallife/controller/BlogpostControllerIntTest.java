package hu.flowacademy.kappaspring.reallife.controller;

import com.github.javafaker.Faker;
import hu.flowacademy.kappaspring.reallife.model.Blogpost;
import hu.flowacademy.kappaspring.reallife.model.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class BlogpostControllerIntTest {

    public static final String BLOGPOSTS_URL = "/api/blogposts";
    @LocalServerPort
    private int port;

    @Autowired
    private Faker faker;

    @BeforeEach
    public void beforeAll() {
        RestAssured.port = port;
    }

    @Test
    public void testGetAllBlogposts() {
        given()
                .log().all()
        .when()
                .get("/api/blogposts")
        .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test
    public void testCreateBlogpost() {
        createBlogpost(null);
    }

    @Test
    public void testUpdateBlogpost() {
        Blogpost oldBlogpost = createBlogpost(null);
        String title = faker.ancient().god();
        String publisher = faker.harryPotter().character();
        String description = faker.harryPotter().quote();

        given()
                .log().all()
                .body(
                        Blogpost.builder()
                                .title(title)
                                .publisher(null)
                                .description(description)
                                .build()
                )
                .contentType(ContentType.JSON)
        .when()
                .put(BLOGPOSTS_URL + "/" + oldBlogpost.getId())
        .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(oldBlogpost.getId()))
                .body("title", equalTo(title))
                .body("description", equalTo(description))
                .body("publisher", equalTo(publisher));
    }

    @Test
    public void testDeleteBlogpost() {

        Blogpost blogpost = createBlogpost(null);
        given()
                .log().all()
        .when()
                .delete(BLOGPOSTS_URL + "/" + blogpost.getId())
        .then()
                .log().all()
                .assertThat()
                .statusCode(202);
    }

    private Blogpost createBlogpost(User publisher) {
        String title = faker.ancient().god();
        String description = faker.harryPotter().quote();
        return given()
                .log().all()
                .body(
                        Blogpost.builder()
                                .title(title)
                                .publisher(publisher)
                                .description(description)
                                .build()
                )
                .contentType(ContentType.JSON)
        .when()
                .post(BLOGPOSTS_URL)
        .then()
                .log().all()
                .assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("title", equalTo(title))
                .body("description", equalTo(description))
                .body("publisher", equalTo(publisher))
        .and()
            .extract().body().as(Blogpost.class);
    }

}