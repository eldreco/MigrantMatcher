package handlers;

import java.util.Scanner;

import dominio.Regiao;

public class Handler {
	protected Scanner sc = new Scanner(System.in);
	
    protected int pedirInteiro(int min, int max){
        String result = null;
        while(true){
            try 
            {
                result = sc.nextLine();
                Integer.parseInt(result);
                if(min <= Integer.parseInt(result) && Integer.parseInt(result) <= max)
                    break;
            } 
            catch (NumberFormatException e) 
            {
                System.out.print("Nao foi introduzido um numero valido, tente outra vez: ");
            }
            
        }
        return Integer.parseInt(result);
    }

    protected Regiao pedirRegiao(){
        Regiao result = null;
        while(true){
            try 
            {
                String regS = sc.nextLine();
                result = Regiao.valueOf(regS);
                break;
            } 
            catch (IllegalArgumentException e) 
            {
                System.out.print("Nao foi introduzida um regiao valida, tente outra vez: ");
            }
            
        }
        return result;
    }
}
