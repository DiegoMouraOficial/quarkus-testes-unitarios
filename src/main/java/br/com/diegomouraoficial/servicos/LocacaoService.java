package br.com.diegomouraoficial.servicos;

import br.com.diegomouraoficial.entidades.Filme;
import br.com.diegomouraoficial.entidades.Locacao;
import br.com.diegomouraoficial.entidades.Usuario;
import br.com.diegomouraoficial.utilitaria.DataUtils;

import java.util.Date;

import static br.com.diegomouraoficial.utilitaria.DataUtils.adicionarDias;

public class LocacaoService {

    public Locacao alugarFilme(Usuario usuario, Filme filme) throws Exception {
        
        // Lancando excessao, caso nao tenha filme em estoque
        if(filme.getEstoque() == 0) {
            throw new Exception("Filme sem estoque");
        }

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
}
