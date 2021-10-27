package br.com.cwi.reset.laercio.controller;

import br.com.cwi.reset.laercio.FakeDatabase;
import br.com.cwi.reset.laercio.domain.Estudio;
import br.com.cwi.reset.laercio.request.EstudioRequest;
import br.com.cwi.reset.laercio.service.EstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudios")
public class EstudioController {

    @Autowired
    private EstudioService estudioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstudio(@RequestBody EstudioRequest estudioRequest) throws Exception {
        this.estudioService.criarEstudio(estudioRequest);
    }

    @GetMapping
    public List<Estudio> listarEstudios(@RequestParam String filtroNome) throws Exception {

        return (List<Estudio>) this.estudioService.consultarEstudios(filtroNome);
    }

    @GetMapping("/id")
    public Optional<Estudio> consultarEstudio(Integer id) throws Exception {

        return this.estudioService.consultarEstudio(id);
    }
}
