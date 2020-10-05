package com.gugawag.pdist.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Mensagem implements Serializable {

    @Id
    private long id;
    private String conteudo;

    public Mensagem() {
    }

    public Mensagem(long id, String conteudo) {
        this.id = id;
        this.conteudo = conteudo;
    }

    public long getId() {  return id;   }

    public void setId(long id) {  this.id = id;  }

    public String getConteudo() {  return conteudo;  }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
