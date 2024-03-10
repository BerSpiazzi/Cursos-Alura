package med.voll.api.record;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.enumeration.EspecialidadesEnum;

public record DadosCadastroMedico(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{2,6}")
        String crm,
        @NotNull
        EspecialidadesEnum especialidade,
        @NotNull
        @Valid
        DadosEndereco endereco) {

}
