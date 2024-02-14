package med.voll.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Medico {

    private String nome;

    private String email;

    private String crm;

    private String especialidade;

    private Endereco endereco;

}
