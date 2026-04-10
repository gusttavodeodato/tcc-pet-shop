package dev.deodato.tcc.petshop.controller;

import dev.deodato.tcc.petshop.model.AgendamentoModel;
import dev.deodato.tcc.petshop.service.AgendamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    // listando agendamentos no BD
    @GetMapping
    public List<AgendamentoModel> listarAgendamentos() {
        return agendamentoService.listarAgendamentos();
    }


    // retornando em id
    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoModel> buscarAgendamento(@PathVariable Long id) {
        return agendamentoService.obterAgendamentoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AgendamentoModel criarAgendamento(@RequestBody AgendamentoModel agendamentoModel) {
        return agendamentoService.criarAgendamento(agendamentoModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgendamento(@PathVariable Long id) {
        agendamentoService.deletarAgendamento(id);
        return ResponseEntity.noContent().build();
    }
}
