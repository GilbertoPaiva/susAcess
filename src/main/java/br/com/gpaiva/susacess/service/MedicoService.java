package br.com.gpaiva.susacess.service;

import br.com.gpaiva.susacess.model.Medico;
import br.com.gpaiva.susacess.model.dto.MedicoInputDTO;
import br.com.gpaiva.susacess.model.dto.MedicoOutDTO;
import br.com.gpaiva.susacess.repository.MedicoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public MedicoOutDTO cadastrar(MedicoInputDTO medicoInputDTO) {
        Medico medico = modelMapper.map(medicoInputDTO, Medico.class);
        medico = medicoRepository.save(medico);
        return modelMapper.map(medico, MedicoOutDTO.class);
    }
}
