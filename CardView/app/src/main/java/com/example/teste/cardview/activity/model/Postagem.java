package com.example.teste.cardview.activity.model;

public class Postagem {
    private String autor;
    private String mensagem;
    private int idImagem;

    public Postagem() {
    }

    public Postagem(String autor, String mensagem, int idImagem) {
        this.autor = autor;
        this.mensagem = mensagem;
        this.idImagem = idImagem;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }
}
