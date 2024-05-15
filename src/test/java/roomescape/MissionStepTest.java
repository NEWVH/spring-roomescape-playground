package roomescape;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.is;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)

public class MissionStepTest {

    @Test
    void 삼단계_예약_추가() {
        Map<String, String> params = new HashMap<>();
        params.put("name", "브라운");
        params.put("date", "2023-08-05");
        params.put("time", "15:40");

        RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(params)
                .when().post("/reservations")
                .then().log().all().statusCode(201)
                .header("Location", "/reservations/1")
                .body("id", is(1));

       RestAssured.given()
              .log().all()
              .when().get("/reservations")
              .then().log().all()
              .statusCode(200).body("size()", is(1));
    }

        @Test
        void 삼단계_예약_취소() {
            Map<String, String> params = new HashMap<>();
            params.put("name", "브라운");
            params.put("date", "2023-08-05");
            params.put("time", "15:40");

            RestAssured.given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .body(params)
                    .when().post("/reservations")
                    .then().log().all().statusCode(201)
                    .header("Location", "/reservations/1")
                    .body("id", is(1));

            RestAssured.given()
                    .log().all()
                    .when().delete("/reservations/1")
                    .then().log().all().statusCode(204);

            RestAssured.given().log().all().when().get("/reservations").then().log().all().statusCode(200).body("size()", is(0));
        }
}
