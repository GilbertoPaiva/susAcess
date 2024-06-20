package br.com.gpaiva.susacess.service;


import br.com.gpaiva.susacess.model.dto.PacienteInputDTO;
import br.com.gpaiva.susacess.model.Paciente;
import br.com.gpaiva.susacess.model.dto.PacienteOutDTO;
import br.com.gpaiva.susacess.repository.PacienteRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PacienteOutDTO cadastrar(PacienteInputDTO pacienteInputDTO) {
        Paciente paciente = modelMapper.map(pacienteInputDTO, Paciente.class);
        paciente = pacienteRepository.save(paciente);
        return modelMapper.map(paciente, PacienteOutDTO.class);
    }
}
