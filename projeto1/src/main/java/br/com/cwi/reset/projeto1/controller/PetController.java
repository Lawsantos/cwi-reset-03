package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetNaoExistenteException;
import br.com.cwi.reset.projeto1.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")


public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> getPet() {

        return petService.listarTodos();
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Pet> getByNome(@PathVariable String nome) throws Exception {

        return ResponseEntity.ok(petService.buscarPetPeloNome(nome));
    }

    private Pet buscarPetPeloNome(String nome) throws Exception {
       return petService.buscarPetPeloNome(nome);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pet cadastrarPet(@RequestBody Pet pet) throws Exception {

        return petService.save(pet);

    }

    @PutMapping
    public Pet atualizarPet(@RequestBody Pet pet) throws Exception {

        return petService.atualizarPet(pet);
    }

    @DeleteMapping("/{nome}")
    public void deletarPet(@PathVariable String nome) throws Exception {

        petService.deletarPet(nome);

    }

}
