package dominio;

import java.util.Date;

public class Ajuda {
	
    private int codigo;
    private String nome;
    private Voluntario voluntario;
    private Date data;

    public Ajuda(String nome, int codigo, Voluntario voluntario){
        this.nome = nome;
        this.codigo = codigo;
        this.voluntario = voluntario;
        
        this.data = new Date();
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

	public Date getData() {
		return data;
	}

}
