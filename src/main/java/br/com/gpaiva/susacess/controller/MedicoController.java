package br.com.gpaiva.susacess.controller;

import br.com.gpaiva.susacess.model.dto.MedicoInputDTO;
import br.com.gpaiva.susacess.model.dto.MedicoOutDTO;

import br.com.gpaiva.susacess.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<MedicoOutDTO> cadastrar(@RequestBody MedicoInputDTO medicoInputDTO) {
        MedicoOutDTO medicoOutDTO = medicoService.cadastrar(medicoInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoOutDTO);
    }

    // Outros endpoints podem ser adicionados aqui
}
