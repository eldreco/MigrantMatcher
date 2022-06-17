package dominio;

public class Ajuda {
	
    private int codigo;
    private String nome;
    private Voluntario voluntario;

    public Ajuda(String nome, int codigo, Voluntario voluntario){
        this.nome = nome;
        this.codigo = codigo;
        this.voluntario = voluntario;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public String getNome(){
        return this.nome;
    }
    
    public Voluntario getVoluntario() {
    	return this.voluntario;
    }
}
