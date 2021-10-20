package br.com.cwi.reset.laercio.controller;

import br.com.cwi.reset.laercio.FakeDatabase;
import br.com.cwi.reset.laercio.request.DiretorRequest;
import br.com.cwi.reset.laercio.service.DiretorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    private DiretorService diretorService;

    public DiretorController() {

        this.diretorService = new DiretorService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor(@RequestBody DiretorRequest diretorRequest) throws Exception{
        this.diretorService.cadastrarDiretor(diretorRequest);

    }
}
