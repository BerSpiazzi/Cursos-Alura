package med.voll.api.model.endereco;

import static java.util.Objects.nonNull;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.record.DadosEndereco;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;

    private String bairro;

    private String cep;

    private String cidade;

    private String uf;

    private String numero;

    private String complemento;

    public Endereco(DadosEndereco endereco) {

        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();

    }

    public Endereco atualizar(DadosEndereco dadosEndereco) {

        this.logradouro = nonNull(dadosEndereco.logradouro()) ? dadosEndereco.logradouro() : this.logradouro;
        this.bairro = nonNull(dadosEndereco.bairro()) ? dadosEndereco.bairro() : this.bairro;
        this.cep = nonNull(dadosEndereco.cep()) ? dadosEndereco.cep() : this.cep;
        this.cidade = nonNull(dadosEndereco.cidade()) ? dadosEndereco.cidade() : this.cidade;
        this.uf = nonNull(dadosEndereco.uf()) ? dadosEndereco.uf() : this.uf;
        this.numero = nonNull(dadosEndereco.numero()) ? dadosEndereco.numero() : this.numero;
        this.complemento = nonNull(dadosEndereco.complemento()) ? dadosEndereco.complemento() : this.complemento;

        return this;

    }
}
