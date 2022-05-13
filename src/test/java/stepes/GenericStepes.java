package stepes;

import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import utils.RestUtils;

import static org.junit.Assert.assertEquals;

public class GenericStepes {
    @Entao("valido que recebo o status {int} no response")
    public void validoQueReceboOStatusNoResponse(Integer status) {

        Assertions.assertEquals(status, RestUtils.getResponse().getStatusCode());

    }

    @Entao("valido que no campo {string} possui valor {string}")
    public void validoQueNoCampoPossuiValor(String key, String value) {

        Assertions.assertEquals(value,RestUtils.getResponse().jsonPath().get(key));
    }
}
