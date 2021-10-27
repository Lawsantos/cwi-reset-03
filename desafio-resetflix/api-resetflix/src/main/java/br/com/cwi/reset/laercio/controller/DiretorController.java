package br.com.cwi.reset.laercio.controller;

import br.com.cwi.reset.laercio.domain.Diretor;
import br.com.cwi.reset.laercio.request.DiretorRequest;
import br.com.cwi.reset.laercio.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    @Autowired
    private DiretorService diretorService;

    @PostMapping
    public void cadastrarDiretor(@RequestBody @Valid DiretorRequest diretorRequest) throws Exception{
        this.diretorService.cadastrarDiretor(diretorRequest);
    }

    @GetMapping
    public List<Diretor> listarDiretores() throws Exception {

        return this.diretorService.listarDiretores();
    }

    @GetMapping("/id")
    public Optional<Diretor> consultarDiretor(Integer id) throws Exception {

        return diretorService.consultarDiretor(id);
    }

    @DeleteMapping(path = "/{id}")
    public void removerDiretores(@PathVariable @Valid Integer id) throws Exception {

        diretorService.removerDiretor(id);
    }

}
