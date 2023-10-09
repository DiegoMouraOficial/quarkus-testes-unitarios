package br.com.diegomouraoficial.servicos;

import br.com.diegomouraoficial.entidades.Filme;
import br.com.diegomouraoficial.entidades.Locacao;
import br.com.diegomouraoficial.entidades.Usuario;
import br.com.diegomouraoficial.utilitaria.DataUtils;
import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static br.com.diegomouraoficial.utilitaria.DataUtils.ehMesmaData;
import static br.com.diegomouraoficial.utilitaria.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Date;

@QuarkusTest
public class LocacaoServiceTest {
    @Test
    public void teste() {

        // cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 3, 5.0);

        // acao
        Locacao locacao = service.alugarFilme(usuario, filme);

        // verificacao
        assertThat(locacao.getValor(), is(equalTo(5.0)));
        assertThat(locacao.getValor(), is(not(6.0)));
        assertThat(ehMesmaData(locacao.getDataLocacao(), new Date()), is(true));
        assertThat(ehMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
    }
}
