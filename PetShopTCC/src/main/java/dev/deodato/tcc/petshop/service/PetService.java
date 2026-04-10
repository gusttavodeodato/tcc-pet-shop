package dev.deodato.tcc.petshop.service;

import dev.deodato.tcc.petshop.model.PetModel;
import dev.deodato.tcc.petshop.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<PetModel> listarPets() {
        return petRepository.findAll();
    }
    
    public PetModel obterPetId(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado."));
    }

    public PetModel criarPet(PetModel pet) {
        return petRepository.save(pet);
        // colocar exceção para validar os dados do pet
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }


}
