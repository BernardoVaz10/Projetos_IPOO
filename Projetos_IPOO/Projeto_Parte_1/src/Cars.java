import java.util.Date;

/**
 * Write a description of class Cars here.
 *
* @author: Tiago Ramada(202200354) & Bernardo Vaz(202200278)
* @email: Tiago(202200354@estudantes.ips.pt)
*         Bernardo(202200278@estudantes.ips.pt)  
* @version 1
 */
public class Cars
{
    // instance variables - replace the example below with your own
    private Car car1, car2, car3;

    /**
     * Constructor for objects of class Cars
     */
    public Cars()
    {
        // initialise instance variables
    }

    // Adiciona o carro que já tinha sido criado
    public void add(Car car){
        if(car1 == null){
            car1 = car;
        } else if (car2 == null){
            car2 = car;
        } else if (car3 == null){
            car3 = car;
        }
    }

    // Comprar um carro
    public void buyCar(String brand, String plate, boolean isHybrid, int fuelUse, int capacity, int hybridFuelCapacity, int hybridCapacity){
        if(car1 == null){
            car1 = new Car(brand, plate, isHybrid, fuelUse, capacity, hybridFuelCapacity, hybridCapacity);
        } else if (car2 == null){
            car2 = new Car(brand, plate, isHybrid, fuelUse, capacity, hybridFuelCapacity, hybridCapacity);
        } else if (car3 == null){
            car3 = new Car(brand, plate, isHybrid, fuelUse, capacity, hybridFuelCapacity, hybridCapacity);
        }
    }

    // Vender um carro
    public void sellCar(Car car){
        if(car == car1){
            car1 = null;
        } else if(car == car2){
            car2 = null;
        } else if(car == car3){
            car3 = null;
        }
    }

    // Selecionar um carro de acordo com a matrícula
    public Car getCar(String plate){
        if(plate.equals(car1.getPlate())){
            return car1;
        } else if (plate.equals(car2.getPlate())){
            return car2;
        } else if (plate.equals(car3.getPlate())){
            return car3;
        }
        return null;
    }

    // Fazer uma viagem
    public void makeTrip(String car, int kms){
        if(car.equals("car1")){
            car1.drive(kms);
        } else if(car.equals("car2")){
            car2.drive(kms);
        } else if(car.equals("car3")){
            car3.drive(kms);
        }
    }

    // Enche o deposito de gasolina
    public void fillCarFuelDeposit(String plate, int value){
            getCar(plate).fill(value);
    }

    // Mostra os carros que precisam de inspeção
    public void showCarsThatNeedInspection(){
        Date date = new Date();
        int currentYear = date.getYear()+1900;
        if((car1.getYearOfCar() - currentYear)%3==0){
            car1.showDescription();
            System.out.println();
        } else if((car2.getYearOfCar() - currentYear)%3==0){
            car2.showDescription();
            System.out.println();
        } else if((car3.getYearOfCar() - currentYear)%3==0){
            car3.showDescription();
            System.out.println();
        }
    }

    // Carrega o carro um x de minutos
    public void chargeCar(String plate, int min, boolean fastCharge){
        Car car = getCar(plate);
        if(car.isOnGarage(car)){
            car.charge(min, fastCharge);
        }
    }
}