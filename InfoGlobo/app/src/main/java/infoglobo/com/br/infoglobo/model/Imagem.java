package infoglobo.com.br.infoglobo.model;

import java.io.Serializable;

/**
 * Created by bruno on 06/04/2017.
 */

public class Imagem implements Serializable {

    private String autor;
    private String fonte;
    private String legenda;
    private String url;

    public Imagem() {

    }

    public Imagem(String autor, String fonte, String legenda, String url) {
        this.autor = autor;
        this.fonte = fonte;
        this.legenda = legenda;
        this.url = url;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Imagem{" +
                "autor='" + autor + '\'' +
                ", fonte='" + fonte + '\'' +
                ", legenda='" + legenda + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
