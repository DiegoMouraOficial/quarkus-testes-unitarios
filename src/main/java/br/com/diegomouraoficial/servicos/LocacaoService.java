package br.com.diegomouraoficial.servicos;

import br.com.diegomouraoficial.entidades.Filme;
import br.com.diegomouraoficial.entidades.Locacao;
import br.com.diegomouraoficial.entidades.Usuario;
import br.com.diegomouraoficial.utilitaria.DataUtils;

import java.util.Date;

import static br.com.diegomouraoficial.utilitaria.DataUtils.adicionarDias;

public class LocacaoService {

    public Locacao alugarFilme(Usuario usuario, Filme filme) {

        Locacao locacao = new Locacao();

        locacao.setFilme(filme);
        locacao.setUsuario(usuario);
        locacao.setDataLocacao(new Date());
        locacao.setValor(filme.getPrelocacao());

        // Entrega no dia seguinte
        Date dataEntrega = new Date();
        dataEntrega = adicionarDias(dataEntrega, 1);
        locacao.setDataRetorno(dataEntrega);

        // Salvando a locacao...

        //TODO adicionar metodo para salvar
        return locacao;

    }

    public static void main(String[] args) {

        // cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 3, 5.0);

        // acao
        Locacao locacao = service.alugarFilme(usuario, filme);

        // verificacao
        System.out.println(locacao.getValor() == 6.0 );
        System.out.println(DataUtils.ehMesmaData(locacao.getDataLocacao(), new Date()));
        System.out.println(DataUtils.ehMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(2)));
    }
}
