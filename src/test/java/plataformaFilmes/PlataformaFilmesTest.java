package plataformaFilmes;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import maps.LoginMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Resources;
import utils.RestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PlataformaFilmesTest {
    static String token;
    @Test
    public void validarLogin() {
        RestUtils.setBaseUri("http://localhost:8080/");

        String json = "{" +
                "    \"email\": \"aluno@email.com\",\n" +
                "    \"senha\": \"123456\"" +
                "}";
        Response response = RestUtils.post(json, ContentType.JSON,"auth");

        assertEquals(200, response.statusCode());
        String token = response.jsonPath().get("token");


    }

    @BeforeAll
    public static void validarLoginMap(){
        RestUtils.setBaseUri("http://localhost:8080/");
        LoginMap.initLogin();
        Response response = RestUtils.post(LoginMap.getLogin(), ContentType.JSON,"auth");

        assertEquals(200, response.statusCode());
         LoginMap.token = response.jsonPath().get("token");


    }

    @Test
   public void validarConsultaCategoria() {
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer " + LoginMap.token);
        Response response = RestUtils.get(header, "categorias");
        assertEquals(200, response.statusCode());
        System.out.println(response.jsonPath().get().toString());

        assertEquals("Acao", response.jsonPath().get("tipo[1]"));
        List<String> listTipo = response.jsonPath().get("tipo");
        assertTrue(listTipo.contains("Sobrevivencia"));

    }




}
