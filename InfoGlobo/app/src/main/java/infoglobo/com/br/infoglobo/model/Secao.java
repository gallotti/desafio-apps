package infoglobo.com.br.infoglobo.model;

import java.io.Serializable;

/**
 * Created by bruno on 06/04/2017.
 */

public class Secao implements Serializable {

    private String nome;
    private String url;

    public Secao() {

    }

    public Secao(String nome, String url) {
        this.nome = nome;
        this.url = url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Secao{" +
                "nome='" + nome + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
