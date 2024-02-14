package med.voll.api.record;

import med.voll.api.enumeration.EspecialidadesEnum;
import med.voll.api.model.Endereco;

public record DadosCadastroMedico(String nome, String email, String crm, EspecialidadesEnum especialidade, DadosEndereco endereco) {

}
