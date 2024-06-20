package br.com.gpaiva.susacess.service;

import org.modelmapper.ModelMapper;
import br.com.gpaiva.susacess.model.Agendamento;
import br.com.gpaiva.susacess.model.dto.AgendamentoInputDTO;
import br.com.gpaiva.susacess.model.dto.AgendamentoOutDTO;
import br.com.gpaiva.susacess.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AgendamentoOutDTO agendar(AgendamentoInputDTO agendamentoInputDTO) {
        Agendamento agendamento = modelMapper.map(agendamentoInputDTO, Agendamento.class);
        agendamento = agendamentoRepository.save(agendamento);
        return modelMapper.map(agendamento, AgendamentoOutDTO.class);
    }
}
