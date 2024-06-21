package br.com.gpaiva.susacess.service;

import br.com.gpaiva.susacess.model.Medico;
import br.com.gpaiva.susacess.model.Paciente;
import br.com.gpaiva.susacess.repository.MedicoRepository;
import br.com.gpaiva.susacess.repository.PacienteRepository;
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
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public AgendamentoOutDTO agendar(AgendamentoInputDTO agendamentoInputDTO) {
        Agendamento agendamento = new Agendamento();
        Medico medico = medicoRepository.findById(agendamentoInputDTO.getMedicoId()).orElseThrow();
        Paciente paciente = pacienteRepository.findById(agendamentoInputDTO.getPacienteId()).orElseThrow();
        agendamento.setMedico(medico);
        agendamento.setPaciente(paciente);
        agendamento.setDataHora(agendamentoInputDTO.getDataHora());
        agendamento = agendamentoRepository.save(agendamento);
        AgendamentoOutDTO agendamentoOutDTO = new AgendamentoOutDTO();
        agendamentoOutDTO.setId(agendamento.getId());
        agendamentoOutDTO.setMedicoId(medico.getId());
        agendamentoOutDTO.setPacienteId(paciente.getId());
        agendamentoOutDTO.setDataHora(agendamento.getDataHora());
        return agendamentoOutDTO;
    }
}