package infoglobo.com.br.infoglobo.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by bruno on 05/04/2017.
 */

public class Content implements Serializable {

    private ArrayList<String> autores;
    private String informePublicitario;
    private String subTitulo;
    private String texto;
    private ArrayList<String> videos;
    private String atualizadoEm;
    private String publicadoEm;
    private String id;
    private Secao secao;
    private String tipo;
    private String titulo;
    private String url;
    private String urlOriginal;
    private ArrayList<Imagem> imagens;

    public Content() {

    }

    public Content(ArrayList<String> autores, String informePublicitario, String subTitulo, String texto, ArrayList<String> videos, String atualizadoEm, String publicadoEm, String id, Secao secao, String tipo, String titulo, String url, String urlOriginal, ArrayList<Imagem> imagens) {
        this.autores = autores;
        this.informePublicitario = informePublicitario;
        this.subTitulo = subTitulo;
        this.texto = texto;
        this.videos = videos;
        this.atualizadoEm = atualizadoEm;
        this.publicadoEm = publicadoEm;
        this.id = id;
        this.secao = secao;
        this.tipo = tipo;
        this.titulo = titulo;
        this.url = url;
        this.urlOriginal = urlOriginal;
        this.imagens = imagens;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }

    public String getInformePublicitario() {
        return informePublicitario;
    }

    public void setInformePublicitario(String informePublicitario) {
        this.informePublicitario = informePublicitario;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public ArrayList<String> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<String> videos) {
        this.videos = videos;
    }

    public String getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(String atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    public String getPublicadoEm() {
        return publicadoEm;
    }

    public void setPublicadoEm(String publicadoEm) {
        this.publicadoEm = publicadoEm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlOriginal() {
        return urlOriginal;
    }

    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    public ArrayList<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(ArrayList<Imagem> imagens) {
        this.imagens = imagens;
    }

    @Override
    public String toString() {
        return "Content{" +
                "autores=" + autores +
                ", informePublicitario='" + informePublicitario + '\'' +
                ", subTitulo='" + subTitulo + '\'' +
                ", texto='" + texto + '\'' +
                ", videos=" + videos +
                ", atualizadoEm='" + atualizadoEm + '\'' +
                ", publicadoEm='" + publicadoEm + '\'' +
                ", id='" + id + '\'' +
                ", secao=" + secao +
                ", tipo='" + tipo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", url='" + url + '\'' +
                ", urlOriginal='" + urlOriginal + '\'' +
                ", imagens=" + imagens +
                '}';
    }
}
