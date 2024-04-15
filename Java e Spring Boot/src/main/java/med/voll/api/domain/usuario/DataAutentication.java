package med.voll.api.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DataAutentication(

        @NotBlank
        String login,
        @NotBlank
        String senha) {
}
