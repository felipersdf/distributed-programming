package com.gugawag.pdist.servlets;

import com.gugawag.pdist.ejbs.MensagemService;
import com.gugawag.pdist.model.Mensagem;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/mensagem.do"})
public class MensagemServlet extends javax.servlet.http.HttpServlet {

    @EJB(lookup="java:module/mensagemService")
    private MensagemService mensagemService;

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        String operacao = request.getParameter("oper");
        PrintWriter resposta = response.getWriter();
        switch (operacao) {
            case "1": {
                long id = Integer.parseInt(request.getParameter("id"));
                String conteudo = request.getParameter("conteudo");
                mensagemService.inserir(id, conteudo);
            }
            case "2": {
                for(Mensagem mensagem: mensagemService.listar()){
                    resposta.println(mensagem.getConteudo());
                }
                break;
            }

            case "3": {
                long id = Integer.parseInt(request.getParameter("id"));
                Mensagem mensagem = mensagemService.pesquisarPorId(id);

                resposta.println("Id:" + mensagem.getId() + "\n Conteudo:" + mensagem.getConteudo());
            }

        }
    }
}
