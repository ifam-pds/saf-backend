package br.edu.ifam.saf.api.data;

import br.edu.ifam.saf.api.dto.BairroDTO;

import java.util.Arrays;
import java.util.List;

public class BairrosResponse {
    private List<BairroDTO> bairros;

    public BairrosResponse(List<BairroDTO> bairros) {
        this.bairros = bairros;
    }

    public BairrosResponse(BairroDTO... itens) {
        this.bairros = Arrays.asList(itens);

    }

    public List<BairroDTO> getBairros() {
        return bairros;
    }

    public void setBairros(List<BairroDTO> bairros) {
        this.bairros = bairros;
    }
}
