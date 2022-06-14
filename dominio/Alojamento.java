package dominio;

public class Alojamento extends Ajuda{

    private int numeroPessoas;
    private Regiao regiao;

    public Alojamento(String nome, int codigo, int numeroPessoas, Regiao regiao) {
        super(nome, codigo);
        this.numeroPessoas = numeroPessoas;
        this.regiao = regiao;
    }
    
    public Regiao getRegiao(){
        return this.regiao;
    }
}
