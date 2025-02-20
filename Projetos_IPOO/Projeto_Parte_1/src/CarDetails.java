
/**
 * Write a description of class CarDetails here.
 *
 * @author: Tiago Ramada(202200354) & Bernardo Vaz(202200278)
 * @email: Tiago(202200354@estudantes.ips.pt)
 *         Bernardo(202200278@estudantes.ips.pt) 
 * @version 1
 */

import java.util.Date;

public class CarDetails
{
    // instance variables
    private String brand, plate;
    private int year;
    private Date date;

    /**
     * Constructor for objects of class CarDetails
     */
    public CarDetails(String brand, String plate)
    {
        // initialise instance variables
        this.brand = brand;
        this.plate = plate;
        date = new Date();
        year = (date.getYear())+1900;
    }

    // Obter a data atual do sistema
    public int getDate(){
        return year;
    }

    // Retorna a marca do carro
    public String getBrand(){
        return brand;
    }

    // Retorna a matricula do carro
    public String getPlate(){
        return plate;
    }
}