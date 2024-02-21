package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.model.medico.Medico;
import med.voll.api.model.medico.MedicoRepository;
import med.voll.api.record.DadosCadastroMedico;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PutMapping
    public String atualizarMedico() {

        return "Atualizando médico";
    }

    @PostMapping
    @Transactional
    public Medico cadastrar(@RequestBody @Valid DadosCadastroMedico medico) {

        return medicoRepository.save(new Medico(medico));
    }

    @GetMapping
    public String listarMedicos() {

        return "Listando médicos";
    }

}
