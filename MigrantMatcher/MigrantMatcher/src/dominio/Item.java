package dominio;

public class Item extends Ajuda{

    private String descricao;

    public Item(String nome, int codigo, String descricao, Voluntario voluntario) {
        super(nome, codigo, voluntario);
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
    	return "Nome: " + this.getNome() + ", descricao: " + this.getDescricao();
    }

	public String getDescricao() {
		return this.descricao;
	}
	
	public boolean equals(Item other) {
		return this.getNome().equals(other.getNome()) && this.getDescricao().equals(other.getDescricao()) && this.getVoluntario().equals(other.getVoluntario());
	}
}
