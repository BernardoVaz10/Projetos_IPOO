
/**
 * Write a description of class Garage here.
 *
 * @author: Tiago Ramada(202200354) & Bernardo Vaz(202200278)
 * @email: Tiago(202200354@estudantes.ips.pt)
 *         Bernardo(202200278@estudantes.ips.pt)
 * @version 1
 */
public class Garage
{
    // instance variables
    private boolean isGarageFree = true;
    private boolean hasFastCharge = false;

    /**
     * Constructor for objects of class Garage
     */
    public Garage()
    {
        // initialise instance variables
    }
    // Estacionar um determinado carro na garagem
    public void park(Car car){
        car.parkCarOnGarage(car);
        isGarageFree = false;
    }

    // Retirar um carro da garagem
    public void leave(Car car){
        car.removeCarFromGarage(car);
        isGarageFree = true;
    }

    // Varificar se a garagem está livre
    public boolean isFree(){
        return isGarageFree;
    }

    // Instalar uma estação de carregamento rápido
    public void installSpeedCharging(){
        hasFastCharge = true;
    }

    // Verificar se uma estação de carregamento rápido
    public boolean HasSpeedCharging(){
        return hasFastCharge;
    }
}