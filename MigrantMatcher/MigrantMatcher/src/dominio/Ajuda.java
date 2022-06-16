package dominio;

public class Ajuda {
    private int codigo;
    private String nome;

    public Ajuda(String nome, int codigo){
        this.nome = nome;
        this.codigo = codigo;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public String getNome(){
        return this.nome;
    }
}
