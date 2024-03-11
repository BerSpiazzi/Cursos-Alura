package med.voll.api.record.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.record.endereco.DadosEndereco;

public record DadosAtualizacaoMedicos(

        @NotNull
        Long id,
        String nome,
        String telefone,
        String email,
        DadosEndereco endereco
) {

}
