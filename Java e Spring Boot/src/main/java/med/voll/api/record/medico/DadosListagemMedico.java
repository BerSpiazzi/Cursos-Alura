package med.voll.api.record.medico;

import med.voll.api.enumeration.EspecialidadesEnum;
import med.voll.api.domain.medico.Medico;

public record DadosListagemMedico(

        Long id,
        String nome,
        String email,
        String crm,
        EspecialidadesEnum especialidade
) {

    public DadosListagemMedico(Medico medico) {

        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
