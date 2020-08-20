package Steps;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.hamcrest.Matchers.is;

import static io.restassured.RestAssured.given;
public class servico {

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void tc_01_incluir_usuario() throws IOException {       //post
        String resultado = "119810905";

        String jsonBody = lerJson("src/test/resources/usuario.json");

        given() //dado que
                .contentType("application/json") //tipo de conteudo REST eh sempre assim
                //existem serviços ASMX e outros, o formatoseria text/xml
                .log().all()                     //gerar um log completo
                //exemplo {"id":1
                .body(jsonBody)

        .when()
                .post("https://petstore.swagger.io/v2/user")
        .then()
                .log().all()
                .statusCode(200)// teste de Interoperabilidade (conectou)
                .body("code",is(200))
                .body("type",is("unknown"))
                .body("message",is(resultado))

        ;
    }

    @Test
    public void tc_02_consultar_usuario() throws IOException {      //get
        String resultado = "119810905";

        String jsonBody = lerJson("src/test/resources/usuario.json");

        given() //dado que
                .contentType("application/json") //tipo de conteudo REST eh sempre assim
                //existem serviços ASMX e outros, o formatoseria text/xml
                .log().all()                     //gerar um log completo
                //exemplo {"id":1
                //.body(jsonBody)

        .when()
                .get("https://petstore.swagger.io/v2/user/AnaClaraWW")
        .then()
                .log().all()
                .statusCode(200)// teste de Interoperabilidade (conectou)
                //.body("code",is(200))
                //.body("type",is("unknown"))
                //.body("message",is(resultado))

        ;
    }

    @Test
    public void tc_03_alterar_usuario() throws IOException {       //put
        String resultado = "119810905";

        String jsonBody = lerJson("src/test/resources/usuario2.json");

        given() //dado que
                .contentType("application/json") //tipo de conteudo REST eh sempre assim
                //existem serviços ASMX e outros, o formatoseria text/xml
                .log().all()                     //gerar um log completo
                //exemplo {"id":1
                .body(jsonBody)

        .when()
                .put("https://petstore.swagger.io/v2/user/AnaClaraWB")
        .then()
                .log().all()
                .statusCode(200)// teste de Interoperabilidade (conectou)
                .body("code",is(200))
                .body("type",is("unknown"))
                .body("message",is(resultado))

        ;
    }
    @Test
    public void tc_04_excluir_usuario() throws IOException {      //delete
        String resultado = "119810905";

        String jsonBody = lerJson("src/test/resources/usuario.json");

        given() //dado que
                .contentType("application/json") //tipo de conteudo REST eh sempre assim
                //existem serviços ASMX e outros, o formatoseria text/xml
                .log().all()                     //gerar um log completo
                //exemplo {"id":1
                //.body(jsonBody)

        .when()
                .delete("https://petstore.swagger.io/v2/user/AnaClaraWW")
        .then()
                .log().all()

                .statusCode(200)// teste de Interoperabilidade (conectou)
        //.body("code",is(200))
        //.body("type",is("unknown"))
        //.body("message",is(resultado))

        ;
    }

}
