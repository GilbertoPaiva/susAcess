package br.com.gpaiva.susacess.controller;
import br.com.gpaiva.susacess.model.dto.AgendamentoInputDTO;
import br.com.gpaiva.susacess.model.dto.AgendamentoOutDTO;
import br.com.gpaiva.susacess.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoOutDTO> agendar(@RequestBody AgendamentoInputDTO agendamentoInputDTO) {
        AgendamentoOutDTO agendamentoOutDTO = agendamentoService.agendar(agendamentoInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(agendamentoOutDTO);
    }

}

