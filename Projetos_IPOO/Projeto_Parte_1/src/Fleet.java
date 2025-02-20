
/**
 * Write a description of class Fleet here.
 *
 * @author: Tiago Ramada(202200354) & Bernardo Vaz(202200278)
 * @email: Tiago(202200354@estudantes.ips.pt)
 *         Bernardo(202200278@estudantes.ips.pt) 
 * @version 1
 */
public class Fleet
{
    // instance variables
    private static int ownedCars = 0;
    private boolean haveGarage = false;
    private String selectedCar;

    private Garage garage;
    private Cars cars = new Cars();

    /**
     * Constructor for objects of class Fleet
     */
    public Fleet(Car car)
    {
        cars.add(car);
        haveGarage = false;
    }
    public Fleet(Garage garage)
    {
        haveGarage = true;
        this.garage = garage;
    }
    public Fleet(Car car, Garage garage)
    {
        cars.add(car);
        haveGarage = true;
    }

    // Verificar se é possível comprar um novo carro para a frota
    public boolean canBuyNewCar(){
        boolean canBuyNewCar = false;
        if(ownedCars < 3){
            canBuyNewCar = true;
        } else {
            canBuyNewCar = false;
        }
        return canBuyNewCar;
    }

    // Saber quantos carros estão na frota
    public int howManyCars(){
        return ownedCars;
    }

    // Comprar um novo carro
    public void buyCar(String brand, String plate, boolean isHybrid, int fuelUse, int capacity, int hybridFuelCapacity, int hybridCapacity){
        if(canBuyNewCar() == true){
            cars.buyCar(brand, plate, isHybrid, fuelUse, capacity, hybridFuelCapacity, hybridCapacity);
            ownedCars++;
        }
    }

    // Vender um carro da frota
    public void sellCar(Car car){
        if(ownedCars > 0){
            cars.sellCar(car);
            ownedCars--;
        }
    }

    // Mostrar os dados da frota
    public void display(){
        System.out.println("Total de carros da frota: " + ownedCars);
        if(haveGarage){
            System.out.println("Possui uma garagem: Sim");
        } else {
            System.out.println("Possui uma garagem: Nao");
        }
        System.out.println("Carro selecionado: " + selectedCar);
    }

    // Realizar uma viagem de carro
    public void makeTrip(int kms){
        if(selectedCar != ""){
            cars.makeTrip(selectedCar, kms);
        }
    }

    // Comprar uma garagem
    public void buyGarage(){
        haveGarage = true;
    }

    // Carregar um determinado carro um determinado número de minutos ou na sua totalidade
    public void charge(String plate, int minutes, boolean fullCharge){
        cars.chargeCar(plate, minutes, fullCharge);
    }

    // Abastecer de gasolina um determinado carro
    public void fill(String plate, int value){
        cars.fillCarFuelDeposit(plate, value);
    }

    // Mostrar os carros que fazem a inspeção no corrente ano (3 em 3 anos)
    public void displayCarsForInspection(){
        cars.showCarsThatNeedInspection();
    }

    // Instalar uma estação de carregamento rápido para a garagem
    public void installGarageSpeedChargeStation(){
        if(haveGarage == true){
            garage.installSpeedCharging();
        }
    }

    // Selecionar um carro de acordo com a matrícula
    public void getCar(String plate){
        selectedCar = (cars.getCar(plate)).toString();
    }
}
