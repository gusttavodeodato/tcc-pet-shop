package dev.deodato.tcc.petshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_agendamentos")
public class AgendamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    private LocalDateTime dataHora;


    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "pet_id", nullable = false) // chave estrangeira
    private PetModel pet;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private ServicoModel servico;
}
