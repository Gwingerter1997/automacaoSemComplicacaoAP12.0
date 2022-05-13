package stepes;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import maps.LoginMap;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class CategoriasStepes {
    Map<String, String> header = new HashMap<>();

    @Dado("que tenha um payload da API de categoria")
    public void queTenhaUmPayloadDaAPIDeCategoria() {
        header.put("Authorization", "Bearer " + LoginMap.token);
    }
    @Quando("realizo uma requisicao do tipo GET de categoria")
    public void realizoUmaRequisicaoDoTipoGETDeCategoria() {
        RestUtils.get(header, "categorias");
    }
}
