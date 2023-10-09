package br.com.diegomouraoficial.servicos;

import br.com.diegomouraoficial.entidades.Filme;
import br.com.diegomouraoficial.entidades.Locacao;
import br.com.diegomouraoficial.entidades.Usuario;
import io.quarkus.test.junit.QuarkusTest;
import org.codehaus.groovy.control.ErrorCollector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;

import static br.com.diegomouraoficial.utilitaria.DataUtils.ehMesmaData;
import static br.com.diegomouraoficial.utilitaria.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.rmi.ConnectException;
import java.util.Date;


@QuarkusTest
public class LocacaoServiceTest {

    @Test
    public void testeLocacao() throws Exception{

        // cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 3, 5.0);

        // acao
        Locacao locacao = service.alugarFilme(usuario, filme);

        // verificacao
        assertThat(locacao.getValor(), is(equalTo(5.0)));
        assertThat(ehMesmaData(locacao.getDataLocacao(), new Date()), is(true));
        assertThat(ehMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
    }

    @Test
    void test_Locacao_filmeSemEstoque() {
        // cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 3, 5.0);

        // acao
       try {
           service.alugarFilme(usuario, filme);
       } catch(Exception e) {
           assertThat(e.getMessage(), is("Filme sem Estoque"));
       }
    }

}
