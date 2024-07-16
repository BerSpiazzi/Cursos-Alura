package med.voll.api.domain.consulta;

import lombok.RequiredArgsConstructor;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class AgendaDeConsultas {

    private final ConsultaRepository consultaRepository;

    private final MedicoRepository medicoRepository;

    private final PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsulta dados) {


        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("Id do paciente inválido");
        }

        if (nonNull(dados.idMedico()) && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoException("Id do médico inválido");
        }

        var medico = escolherMedico(dados);
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());

        var consulta = new Consulta(null, medico, paciente, dados.data());

        consultaRepository.save(consulta);

    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {

        if (nonNull(dados.idMedico())) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if(isNull(dados.especialidade())) {
            throw new ValidacaoException("Especialidade é obrigatória quando não informado o médico");
        }


        return medicoRepository.escolherMedicoPorEspecialidade(dados.especialidade(), dados.data());
    }
}
