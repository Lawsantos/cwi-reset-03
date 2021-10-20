package br.com.cwi.reset.laercio.controller;

import br.com.cwi.reset.laercio.FakeDatabase;
import br.com.cwi.reset.laercio.AtorEmAtividade;
import br.com.cwi.reset.laercio.domain.Ator;
import br.com.cwi.reset.laercio.exception.NenhumCadastroException;
import br.com.cwi.reset.laercio.request.AtorRequest;
import br.com.cwi.reset.laercio.service.AtorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@ResponseStatus(HttpStatus.CREATED)
@RestController
@RequestMapping("/atores")
public class AtorController {

    private AtorService atorService;

    public AtorController() {

        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    @PostMapping
    public void criarAtor(@RequestBody AtorRequest atorRequest) throws Exception{
        this.atorService.criarAtor(atorRequest);

    }

    @GetMapping("/em_atividade")
    public ResponseEntity<List<AtorEmAtividade>> listarAtoresEmAtividade(@RequestParam("filtroNome") String filtroNome) throws Exception {
        return ResponseEntity.ok(this.atorService.listarAtoresEmAtividade());

    }

    @GetMapping
    public ResponseEntity<List<Ator>> consultarAtores() throws Exception {

        return ResponseEntity.ok(this.atorService.consultarAtores());
    }

    @GetMapping("/id")
    public Ator consultarAtor(Integer id) throws Exception {

        return atorService.consultarAtor(id);
    }
}
