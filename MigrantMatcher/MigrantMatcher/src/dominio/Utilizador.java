package dominio;

public class Utilizador {

    private int id;
    private int contacto;

    public Utilizador(int id, int contacto){
        this.id = id;
        this.contacto = contacto;
    }

    public int getID(){
        return this.id;
    }

    public int getContacto(){
        return this.contacto;
    }
}
