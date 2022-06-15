package dominio;

public class Item extends Ajuda{

    private String descricao;

    public Item(String nome, int codigo, String descricao) {
        super(nome, codigo);
        this.descricao = descricao;
    }
    
}
