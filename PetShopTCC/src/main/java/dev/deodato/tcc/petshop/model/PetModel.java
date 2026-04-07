package dev.deodato.tcc.petshop.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_pets")
public class PetModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String especie;


    /// muitos pets pode ter vários donos
    @ManyToMany
    @JoinTable(
            name = "pet_tutor",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "tutor_id")
    )
    private List<TutorModel> tutores;

    public PetModel() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public List<TutorModel> getTutores() {
        return tutores;
    }

    public void setTutores(List<TutorModel> tutores) {
        this.tutores = tutores;
    }
}
