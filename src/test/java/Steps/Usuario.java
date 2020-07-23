package Steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Usuario {
    //RestAssured restAssured = new RestAssured();
    RequestSpecification requestSpecification = RestAssured.given();
    //Response response;

    @Dado("^a requisicao contem \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" (\\d+)$")
    public void a_requisicao_contem(String id, String username, String firstname, String lastname, String email, String password, String phone, int userStatus) throws Throwable {
        requestSpecification.given()
                .contentType("application/json")

                .log().all()


                .body("{\"id\": " + id + "," +
                        "\"username\":" + username + "," +
                        "\"firstname\":" + firstname + "," +
                        "\"lastname\":" + lastname + "," +
                        "\"email\":" + email + "," +
                        "\"password\":" + password + "," +
                        "\"phone\":" + phone + "," +
                        "\"userStatus\":" + userStatus + "}");
    }

    @Quando("^conecto com a uri da PetShop$")
    public void conecto_com_a_uri_da_PetShop() throws Throwable {
        requestSpecification.when()
                .post("https://petstore.swagger.io/v2/user");
    }

    @Entao("^valido (\\d+) \"([^\"]*)\" \"([^\"]*)\"$")
    public void valido(int code , String type, String message) throws Throwable {
        requestSpecification.then()
                .log().all()
                .statusCode(200) // Teste de Interoperabilidade (Conectou)
                .body("code",is(code))
                .body("type",is(type))
                .body("message",is(message));
    }

    @Entao("^pesquiso \"([^\"]*)\"$")
    public void pesquiso(String username) throws Throwable {
        given() //dado que
                .contentType("application/json")

                .log().all()

                .body("{\"username\":" + username + "}")

                .when()
                .get("https://petstore.swagger.io/v2/user/" + username)
                .then()
                .log().all()
                .statusCode(404)// teste de Interoperabilidade (conectou)
        //.body("code",is(200))
        //.body("type",is("unknown"))
        //.body("message",is(resultado))

        ;

    }
    @Entao("^altero \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void altero(String username, String lastname, String email) throws Throwable {
        //TODO
        requestSpecification.given() // Dado que
                .contentType("application/json") // Tipo do conteudo REST é sempre assim
                // Existem serviços ASMX e outros, o formato seria text/xml
                .log().all()
                    .body("{\"username\":" + username + "," +
                            "\"username\":" + username + "," +
                            "\"lastname\":" + lastname + "," +
                            "\"email\":" + email + "," +"}");


            ;
        }

    @Entao("^excluo \"([^\"]*)\"$")
    public void excluo(String username) throws Throwable {
        given() //dado que
                .contentType("application/json") //tipo de conteudo REST eh sempre assim
                //existem serviços ASMX e outros, o formatoseria text/xml
                .log().all()                     //gerar um log completo
                //exemplo {"id":1
                //.body(jsonBody)

                .when()
                .delete("https://petstore.swagger.io/v2/user/" + username)
                .then()
                .log().all()
                .statusCode(404)// teste de Interoperabilidade (conectou)
        //.body("code",is(200))
        //.body("type",is("unknown"))
        //.body("message",is(resultado))

        ;

    }


}







