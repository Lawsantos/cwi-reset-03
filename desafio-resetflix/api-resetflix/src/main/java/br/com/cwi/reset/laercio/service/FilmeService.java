package br.com.cwi.reset.laercio.service;

import br.com.cwi.reset.laercio.FakeDatabase;
import br.com.cwi.reset.laercio.domain.Filme;
import br.com.cwi.reset.laercio.domain.Genero;
import br.com.cwi.reset.laercio.domain.PersonagemAtor;
import br.com.cwi.reset.laercio.exception.CampoNuloException;
import br.com.cwi.reset.laercio.exception.NaoEncontradoException;
import br.com.cwi.reset.laercio.exception.NenhumCadastroException;
import br.com.cwi.reset.laercio.exception.NomeIgualException;
import br.com.cwi.reset.laercio.request.FilmeRequest;

import java.util.*;

import static java.util.Objects.isNull;
import static java.util.Optional.ofNullable;

public class FilmeService {

    private DiretorService diretorService;
    private EstudioService estudioService;
    private PersonagemAtorService personagemAtorService;

//    public FilmeService(FakeDatabase fakeDatabase) {
//        this.fakeDatabase = fakeDatabase;
//        this.diretorService = new DiretorService(fakeDatabase);
//        this.estudioService = new EstudioService(fakeDatabase);
//        this.personagemAtorService = new PersonagemAtorService(fakeDatabase);
//    }

//    public void criarFilme(FilmeRequest filmeRequest) throws Exception {
//        final List<Filme> filmesCadastrados = fakeDatabase.recuperaFilmes();
//
//        final Integer idGerado = filmesCadastrados.size() + 1;
//
//        final Filme filme = new Filme(
//                ofNullable(filmeRequest.getNome()).orElseThrow(() -> new CampoNuloException("Campo obrigatório não informado. Favor informar o campo nome.")),
//                ofNullable(filmeRequest.getAnoLancamento()).orElseThrow(() -> new CampoNuloException("Campo obrigatório não informado. Favor informar o campo ano de lançamento.")),
//                ofNullable(filmeRequest.getCapaFilme()).orElseThrow(() -> new CampoNuloException("Campo obrigatório não informado. Favor informar o campo capa filme.")),
//                ofNullable(filmeRequest.getGeneros()).orElseThrow(() -> new CampoNuloException("Campo obrigatório não informado. Favor informar o campo genero.")),
//                estudioService.consultarEstudio(filmeRequest.getIdEstudio()),
//                diretorService.consultarDiretor(filmeRequest.getIdDiretor()),
//                personagemAtorService.cadastrarPersonagensFilme(filmeRequest.getPersonagens()),
//                ofNullable(filmeRequest.getResumo()).orElseThrow(() -> new CampoNuloException("Campo obrigatório não informado. Favor informar o campo resumo."))
//        );
//
//
//        if (filme.getGeneros().isEmpty()) {
//            throw new CampoNuloException("Deve ser informado pelo menos um gênero para o cadastro do filme.");
//        }
//
//        final Set<Genero> generoSet = new HashSet<>();
//
//        for (Genero genero : filme.getGeneros()) {
//            if (generoSet.contains(genero)) {
//                throw new NomeIgualException("Não é permitido informar o mesmo gênero mais de uma vez para o mesmo filme.");
//            } else {
//                generoSet.add(genero);
//            }
//        }
//
//        fakeDatabase.persisteFilme(filme);
//    }
//
//    public List<Filme> consultarFilmes(
//            String nomeFilme,
//            String nomeDiretor,
//            String nomePersonagem,
//            String nomeAtor) throws Exception {
//        final List<Filme> filmesCadastrados = fakeDatabase.recuperaFilmes();
//
//        if (filmesCadastrados.isEmpty()) {
//            throw new NenhumCadastroException("Nenhum filme cadastrado, favor cadastar filmes");
//        }
//
//        final List<Filme> filtrarNomePersonagem = filtrarNomePersonagem(filmesCadastrados, nomePersonagem);
//        final List<Filme> filtrarNomeAtor = filtrarNomeAtor(filtrarNomePersonagem, nomeAtor);
//        final List<Filme> filtrarNomeDiretor = filtrarNomeDiretor(filtrarNomeAtor, nomeDiretor);
//        final List<Filme> filtroFinal = filtrarNomeFilme(filtrarNomeDiretor, nomeFilme);
//
//        if (filtroFinal.isEmpty()) {
//            throw new NaoEncontradoException(
//                    String.format(
//                            "Filme não encontrado com os filtros nomeFilme=%s, nomeDiretor=%s, nomePersonagem=%s, nomeAtor=%s, favor informar outros filtros.",
//                            nomeFilme,
//                            nomeDiretor,
//                            nomePersonagem,
//                            nomeAtor
//                    )
//            );
//        }
//
//        return filtroFinal;
//    }

    private List<Filme> filtrarNomeFilme(final List<Filme> listaOriginal, final String nome) {
        if (isNull(nome)) {
            return listaOriginal;
        }

        final List<Filme> filmeFiltrado = new ArrayList<>();

        for (Filme filme : listaOriginal) {
            if (filme.getNome().toLowerCase(Locale.ROOT).equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))) {
                filmeFiltrado.add(filme);
            }
        }

        return filmeFiltrado;
    }

    private List<Filme> filtrarNomeDiretor(final List<Filme> listaOriginal, final String nome) {
        if (isNull(nome)) {
            return listaOriginal;
        }

        final List<Filme> filmeFiltrado = new ArrayList<>();

        for (Filme filme : listaOriginal) {
            if (filme.getDiretor().getNome().toLowerCase(Locale.ROOT).equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))) {
                filmeFiltrado.add(filme);
            }
        }

        return filmeFiltrado;
    }

    private List<Filme> filtrarNomeAtor(final List<Filme> listaOriginal, final String nome) {
        if (isNull(nome)) {
            return listaOriginal;
        }

        final List<Filme> filmeFiltrado = new ArrayList<>();

        for (Filme filme : listaOriginal) {
            for (PersonagemAtor personagens : filme.getPersonagens()) {
                if (personagens.getAtor().getNome().toLowerCase(Locale.ROOT).equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))) {
                    filmeFiltrado.add(filme);
                    break;
                }
            }
        }

        return filmeFiltrado;
    }

    private List<Filme> filtrarNomePersonagem(final List<Filme> listaOriginal, final String nome) {
        if (isNull(nome)) {
            return listaOriginal;
        }

        final List<Filme> filmeFiltrado = new ArrayList<>();

        for (Filme filme : listaOriginal) {
            for (PersonagemAtor personagens : filme.getPersonagens()) {
                if (personagens.getNomePersonagem()
                        .toLowerCase(Locale.ROOT)
                        .equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))
                ) {
                    filmeFiltrado.add(filme);
                    break;
                }
            }
        }

        return filmeFiltrado;
    }
}
