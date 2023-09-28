package br.com.diegomouraoficial.servicos;

import br.com.diegomouraoficial.entidades.Filme;
import br.com.diegomouraoficial.entidades.Locacao;
import br.com.diegomouraoficial.entidades.Usuario;
import br.com.diegomouraoficial.utilitaria.DataUtils;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.wildfly.common.Assert;

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
        Assert.assertTrue(locacao.getValor() == 5.0 );
        Assert.assertTrue(DataUtils.ehMesmaData(locacao.getDataLocacao(), new Date()));
        Assert.assertTrue(DataUtils.ehMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
    }
}
