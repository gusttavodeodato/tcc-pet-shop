package dev.deodato.tcc.petshop.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.AjAttribute;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_servicos")
public class ServicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private Double preco;

}
