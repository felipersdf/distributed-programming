package com.gugawag.pdist.ejbs;

import com.gugawag.pdist.model.Mensagem;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Stateless(name="mensagemService")
@Remote
public class MensagemService {

    @EJB
    private MensagemDAO mensagemDao;

    public List<Mensagem> listar() {
        return mensagemDao.listar();
    }

    public void inserir(long id, String conteudo) {
        Mensagem novaMensagem = new Mensagem(id, conteudo);
        mensagemDao.inserir(novaMensagem);
        if (conteudo.equals("")) throw new RuntimeException("Não é possível adicionar mensagem sem conteudo!");
    }

    public Mensagem pesquisarPorId(long id) {
        return mensagemDao.pesquisarPorId(id);
    }


}
