package br.com.cwi.reset.laercio.controller;

import br.com.cwi.reset.laercio.AtorEmAtividade;
import br.com.cwi.reset.laercio.domain.Ator;
import br.com.cwi.reset.laercio.exception.IdNuloException;
import br.com.cwi.reset.laercio.request.AtorRequest;
import br.com.cwi.reset.laercio.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atores")
public class AtorController {

    @Autowired
    private AtorService atorService;

    @PostMapping
    public void criarAtor(@RequestBody @Valid AtorRequest atorRequest) throws Exception{
        this.atorService.criarAtor(atorRequest);

    }

    @GetMapping("/em_atividade")
    public List<AtorEmAtividade> listarAtoresEmAtividade(@RequestParam String filtroNome) throws Exception {
        return this.atorService.listarAtoresEmAtividade(filtroNome);

    }

//    @PutMapping(path = "/{id}")
//    public void atualizarAtor(@PathVariable @Valid Integer id, AtorRequest atorRequest) throws Exception {
//        this.atorService.atualizarAtor(id, atorRequest);
//    }

    @GetMapping
    public List<Ator> consultarAtores() throws Exception {

        return this.atorService.consultarAtores();
    }

    @GetMapping("/id")
    public Optional<Ator> consultarAtor(@RequestParam Integer id) throws Exception {

        return atorService.consultarAtor(id);
    }

    @DeleteMapping(path = "/{id}")
    public void removerAtor(@PathVariable @Valid Integer id) throws Exception {

        atorService.removerAtor(id);
    }
}
