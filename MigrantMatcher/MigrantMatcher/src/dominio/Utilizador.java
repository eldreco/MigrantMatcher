package dominio;

public class Utilizador {

    private int id;
    private String nome;
    private int contacto;

    public Utilizador(int id, String nome, int contacto){
        this.id = id;
        this.nome = nome;
        this.contacto = contacto;
    }

    public int getID(){
        return this.id;
    }

    public int getContacto(){
        return this.contacto;
    }

	public String getNome() {
		return nome;
	}

}
