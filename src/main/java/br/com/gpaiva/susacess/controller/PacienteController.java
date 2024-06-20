package br.com.gpaiva.susacess.controller;


import br.com.gpaiva.susacess.model.dto.PacienteInputDTO;
import br.com.gpaiva.susacess.model.dto.PacienteOutDTO;
import br.com.gpaiva.susacess.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteOutDTO> cadastrar(@RequestBody PacienteInputDTO pacienteInputDTO) {
        PacienteOutDTO pacienteOutDTO = pacienteService.cadastrar(pacienteInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteOutDTO);
    }

    // Outros endpoints podem ser adicionados aqui
}
