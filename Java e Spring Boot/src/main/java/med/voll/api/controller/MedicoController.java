package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.model.medico.Medico;
import med.voll.api.model.medico.MedicoRepository;
import med.voll.api.record.DadosAtualizacaoMedicos;
import med.voll.api.record.DadosCadastroMedico;
import med.voll.api.record.DadosListagemMedico;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedicos dados) {

        Medico medico = medicoRepository.getReferenceById(dados.id());

        medico.atualizar(dados);
    }

    @PostMapping
    @Transactional
    public Medico cadastrar(@RequestBody @Valid DadosCadastroMedico medico) {

        return medicoRepository.save(new Medico(medico));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {

        return medicoRepository.findAllByAtivoTrue(pageable).map(DadosListagemMedico::new);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {

        Medico medico = medicoRepository.getReferenceById(id);
        medico.inativar();
    }

}
