package model;

public class Categoria {
    private int codigoCategoria;
    private String nome;

    public Categoria(int codigoCategoria, String nome) {
        this.codigoCategoria = codigoCategoria;
        this.nome = nome;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
