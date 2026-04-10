package dev.deodato.tcc.petshop.service;

import dev.deodato.tcc.petshop.model.AgendamentoModel;
import org.springframework.stereotype.Service;
import dev.deodato.tcc.petshop.repository.AgendamentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    public List<AgendamentoModel> listarAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public Optional<AgendamentoModel> obterAgendamentoPorId(Long id) {
        return agendamentoRepository.findById(id);
    }

    public AgendamentoModel criarAgendamento(AgendamentoModel agendamentoModel) {
        return agendamentoRepository.save(agendamentoModel);
        // criar exceção para criar agendamentos, como não deixar agendar
        // para datas passadas e nem agendar o pet duas vezes no mesmo horario
    }

    public void deletarAgendamento(Long id) {
        agendamentoRepository.deleteById(id);
    }
}
