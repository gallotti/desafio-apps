package infoglobo.com.br.infoglobo.model;

import java.util.ArrayList;

/**
 * Created by bruno on 05/04/2017.
 */

public class Couver {

    private ArrayList<Content> conteudos;
    private String produto;

    public Couver() {

    }

    public Couver(ArrayList<Content> conteudos, String produto) {
        this.conteudos = conteudos;
        this.produto = produto;
    }

    public ArrayList<Content> getConteudos() {
        return conteudos;
    }

    public void setConteudos(ArrayList<Content> conteudos) {
        this.conteudos = conteudos;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Content{" +
                "conteudos=" + conteudos +
                ", produto='" + produto + '\'' +
                '}';
    }
}
