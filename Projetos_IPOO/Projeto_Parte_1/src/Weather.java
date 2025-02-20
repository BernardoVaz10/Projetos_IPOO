
/**
 * Write a description of class Weather here.
 *
 * @author: Tiago Ramada(202200354) & Bernardo Vaz(202200278)
 * @email: Tiago(202200354@estudantes.ips.pt)
 *         Bernardo(202200278@estudantes.ips.pt) 
 * @version 1
 */
import java.util.Random;


public class Weather
{
    // instance variables
    private String weather;
    private double electricalUse;
    Random rand;

    /**
     * Constructor for objects of class Weather
     */
    public Weather()
    {
        // initialise instance variables
        weather = "";
    }

    // Verificar como esta o tempo
    public double checker(){
        weather = weather();
        if(weather == "Frio"){
            electricalUse = 0.07;
        } else if(weather == "Normal"){
            electricalUse = 0.00;
        } else if(weather == "Quente"){
            electricalUse = 0.05;
        } else if(weather == "Muito Quente"){
            electricalUse = 0.10;
        }
        return electricalUse;
    }

    // Gera um valor de tempo
    public String weather(){
        rand = new Random();
        int i = rand.nextInt(4);

        if(i == 0){
            weather = "Frio";
        } else if(i == 1){
            weather = "Normal";
        } else if(i == 2){
            weather = "Quente";
        } else if(i == 3){
            weather = "Muito Quente";
        }
        return weather;
    }
}
