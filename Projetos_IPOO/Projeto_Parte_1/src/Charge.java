
/**
 * Write a description of class Charge here.
 *
 * @author: Tiago Ramada(202200354) & Bernardo Vaz(202200278)
 * @email: Tiago(202200354@estudantes.ips.pt)
 *         Bernardo(202200278@estudantes.ips.pt) 
 * @version 1
 */
public class Charge
{
    // instance variables
    private final int normalCharge = 6;
    private final int fastCharge = 18;
    private int chargeValue;

    /**
     * Constructor for objects of class Charge
     */
    public Charge(boolean fastCharge)
    {
        // initialise instance variables
        if(fastCharge){
            chargeValue = this.fastCharge;
        } else {
            chargeValue = this.normalCharge;
        }
    }
    //Vai carregar bateria e vai retornar o valor do nivel da bateria, apos ter carregado o x de minutos
    public double charge(int min){
            double result = (min * chargeValue)/60;
            return result;
    }
}
