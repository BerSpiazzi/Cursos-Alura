package med.voll.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.record.DadosCadastroMedico;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PutMapping
    public String atualizarMedico() {

        return "Atualizando médico";
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody DadosCadastroMedico medico) {

        return ResponseEntity.ok(medico);
    }

    @GetMapping
    public String listarMedicos() {

        return "Listando médicos";
    }

}
