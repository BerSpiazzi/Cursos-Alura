package med.voll.api.record;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedicos(

        @NotNull
        Long id,
        String nome,
        String telefone,
        String email,
        DadosEndereco endereco
) {

}
