package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetJaExistenteException;
import br.com.cwi.reset.projeto1.exception.PetNaoExistenteException;
import br.com.cwi.reset.projeto1.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public Pet save(Pet pet) throws Exception {
        Pet petJaExistente = repository.buscaPeloNome(pet.getNome());

        if (petJaExistente != null) {
            throw new PetJaExistenteException("Pet com o nome " + pet.getNome() + " já existe");
        }
        repository.save(pet);
        return pet;
    }

    public Pet buscarPetPeloNome(String nome) throws Exception {
        Pet pet = repository.buscaPeloNome(nome);

        if (pet == null) {
            throw new PetNaoExistenteException("Pet com o nome " + nome + ", não existe.");
        }
        return pet;
    }

    public void deletarPet(String nomePet) throws Exception{

        Pet pet = buscarPetPeloNome(nomePet);
        if (pet == null) {
            throw new PetNaoExistenteException("Pet com o nome " + nomePet + " não existe");
        }
        repository.delete(pet);
    }

    public Pet atualizarPet(Pet pet) throws Exception {
        Pet petCadastrado = repository.buscaPeloNome(pet.getNome());

        if (petCadastrado == null) {
            throw new PetNaoExistenteException("Pet com o nome " + pet.getNome() + " não existe.");

        }
        return repository.update(pet);
    }

    public List<Pet> listarTodos(){

        return repository.listAll();
    }

}
