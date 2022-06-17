package dominio;

public class Alojamento extends Ajuda{

    private int numeroPessoas;
    private Regiao regiao;

    public Alojamento(String nome, int codigo, int numeroPessoas, Regiao regiao, Voluntario voluntario) {
        super(nome, codigo, voluntario);
        this.numeroPessoas = numeroPessoas;
        this.regiao = regiao;
    }
    
    public Regiao getRegiao(){
        return this.regiao;
    }
    
    public int getNumeroPessoas() {
    	return this.numeroPessoas;
    }
    
    @Override
    public String toString() {
    	return "Nome: " + this.getNome() + ", numero de pessoas que pode alojar: " + this.getNumeroPessoas();
    }
}
