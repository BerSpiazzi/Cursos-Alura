package med.voll.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {

    private String logradouro;

    private String bairro;

    private String cep;

    private String cidade;

    private String uf;

    private String numero;

    private String complemento;

}
