package med.voll.api.model.medico;

import static java.util.Objects.nonNull;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.enumeration.EspecialidadesEnum;
import med.voll.api.model.endereco.Endereco;
import med.voll.api.record.DadosAtualizacaoMedicos;
import med.voll.api.record.DadosCadastroMedico;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String crm;

    @Enumerated(EnumType.STRING)
    private EspecialidadesEnum especialidade;

    @Embedded
    private Endereco endereco;

    private boolean ativo;

    public Medico(DadosCadastroMedico medico) {

        this.ativo = true;
        this.nome = medico.nome();
        this.email = medico.email();
        this.crm = medico.crm();
        this.telefone = medico.telefone();
        this.especialidade = medico.especialidade();
        this.endereco = new Endereco(medico.endereco());

    }

    public void atualizar(DadosAtualizacaoMedicos dados) {

        this.nome = nonNull(dados.nome()) ? dados.nome() : this.nome;
        this.telefone = nonNull(dados.telefone()) ? dados.telefone() : this.telefone;
        this.email = nonNull(dados.email()) ? dados.email() : this.email;
        this.endereco = nonNull(dados.endereco()) ? this.endereco.atualizar(dados.endereco()) : this.endereco;

    }

    public void inativar() {

        this.ativo = false;

    }
}
