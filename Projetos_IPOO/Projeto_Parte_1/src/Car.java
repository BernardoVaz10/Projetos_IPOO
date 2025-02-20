
/**
 * Write a description of class Car here.
 *
 * @author: Tiago Ramada(202200354) & Bernardo Vaz(202200278)
 * @email: Tiago(202200354@estudantes.ips.pt)
 *         Bernardo(202200278@estudantes.ips.pt) 
 * @version 1
 */

import java.time.Year;
import java.util.Date;

public class Car {
    // instance variables
    private String brand, plate;
    private boolean isHybrid;
    private int fuelUse;
    private int eletricalCapacity, hybridFuelCapacity, hybridCapacity;
    private boolean isCharged, isOnGarage;

    private Deposit eletricalDeposit, hybridEletricalDeposit, hybridFuelDeposit;
    private Charge charge;
    private Weather weather = new Weather();
    private CarDetails carDetails;

    private double weatherValue = weather.checker();

    /**
     * Constructor for objects of class Car
     */
    public Car(String brand, String plate, boolean isHybrid, int fuelUse, int eletricalCapacity, int hybridFuelCapacity,
            int hybridCapacity) {
        // initialise instance variables
        this.carDetails = new CarDetails(brand, plate);
        this.brand = carDetails.getBrand();
        this.plate = carDetails.getPlate();
        this.isHybrid = isHybrid;
        this.fuelUse = fuelUse;

        if (isHybrid == true) {
            this.hybridFuelCapacity = hybridFuelCapacity;
            this.hybridCapacity = hybridCapacity;
            createHybridDeposits(hybridFuelCapacity, hybridCapacity);
        } else {
            this.eletricalCapacity = eletricalCapacity;
            createElectricalDeposit(eletricalCapacity);
        }
    }

    // Varificar se é híbrido
    public boolean isHybrid() {
        return isHybrid;
    }

    // Encher o depósito de gasolina, se for um carro híbrido
    public void fullFill() {
        if (isHybrid = true) {
            hybridFuelDeposit.fullFill();
        }
    }

    // Carregar o carro um determinado número de minutos
    public void charge(int min, boolean fastCharge) {
        charge = new Charge(fastCharge);
        double totalToCharge = charge.charge(min);
        if(isHybrid){
            hybridEletricalDeposit.fill(totalToCharge);
        } else {
            eletricalDeposit.fill(totalToCharge);
        }
    }

    // Verifica se está carregado
    public boolean isCharged() {
        return isCharged;
    }

    // Adicionar um determinado valor de carga/gasolina
    public void fill(int value) {
        hybridFuelDeposit.updateLevel(value);
    }

    // Conduzir uma determinada distancia. A realização desta viagem conduz a um consumo de energia. Este consumo irá depender da distância da viagem e das condições meteorológicas que podem aumentar o mesmo
    public void drive(int kms) {
        if (getAutonomy() >= kms) {
            if (!isHybrid) {
                int newLevel = (int) ((eletricalDeposit.getLevel() * kms) / getAutonomy());
                eletricalDeposit.updateLevel(newLevel);
            } else {
                int newLevel = (int) ((hybridEletricalDeposit.getLevel() * kms)
                        / ((fuelUse / (hybridEletricalDeposit.getLevel() * 100)) * weatherValue));
                hybridEletricalDeposit.updateLevel(newLevel);

                if (hybridEletricalDeposit.getLevel() < 0) {
                    hybridFuelDeposit.updateLevel(hybridEletricalDeposit.getLevel() + hybridFuelDeposit.getLevel());
                    hybridEletricalDeposit.updateLevel(0);
                    if (hybridFuelDeposit.getLevel() < 0) {
                        hybridFuelDeposit.updateLevel(0);
                    }
                }
            }
        }
    }

    // Obter a autonomia
    public double getAutonomy() {
        if (!isHybrid) {
            return ((fuelUse / (eletricalDeposit.getLevel() * 100)) * weatherValue);
        } else {
            // double weatherValue = weather.checker();
            double autonomyElectrical = ((fuelUse / (hybridEletricalDeposit.getLevel() * 100)) * weatherValue);
            double autonomyFuel = ((fuelUse / (hybridFuelDeposit.getLevel() * 100)) * weatherValue);
            return (autonomyElectrical + autonomyFuel);
        }
    }

    // Mostrar a descrição, mostrada na figura 2 do enunciado
    public void showDescription() {
        System.out.println(brand + " " + plate);
        fuelCheck();
        System.out.println("Autonomia: " + getAutonomy());
    }

    // Mostrar uma descrição completa, com as informações adicionais do consumo e do nível
    public void showFullDescription() {
        System.out.println("Marca: " + brand);
        System.out.println("Matrícula: " + plate);
        fuelCheck();
        System.out.println("Autonomia: " + getAutonomy());
        System.out.println("Consumo: " + fuelUse);
        System.out.println("Capacidade do depósito: " + eletricalCapacity);
    }

    // Verifica se o tipo de combustivel a usar é de hibrido ou eletrico
    public void fuelCheck() {
        if (isHybrid == true) {
            System.out.println("Combustível: Híbrido");
        } else {
            System.out.println("Combustível: Elétrico");
        }
    }

    // retorna o carDetails
    public CarDetails getCarDetails() {
        return carDetails;
    }

    // retorna a matricula do carro
    public String getPlate() {
        return carDetails.getPlate();
    }

    // Cria o deposito eletrico
    public void createElectricalDeposit(int chargeOfDeposit) {
        if (!isHybrid && chargeOfDeposit <= eletricalCapacity) {
            eletricalDeposit = new Deposit(eletricalCapacity, chargeOfDeposit);
        }
    }

    // Cria os depositos do hybrid
    public void createHybridDeposits(int levelOfDeposit, int chargeOfDeposit) {
        if (isHybrid && chargeOfDeposit <= hybridCapacity && levelOfDeposit <= hybridFuelCapacity) {
            hybridEletricalDeposit = new Deposit(hybridCapacity, chargeOfDeposit);
            hybridFuelDeposit = new Deposit(hybridFuelCapacity, levelOfDeposit);
        }
    }

    // Verifica se o carro está na garagem
    public void parkCarOnGarage(Car car){
        car.isOnGarage = true;
    }

    // Remove o carro da garagem
    public void removeCarFromGarage(Car car){
        car.isOnGarage = false;
    }

    // Verifica se o carro esta na garagem
    public boolean isOnGarage(Car car){
        return isOnGarage;
    }

    // Retorna o ano do carro
    public int getYearOfCar() {
        return carDetails.getDate();
    }

    // Retorna os depositos
    public Deposit getElectricalDeposit() {
        return eletricalDeposit;
    }

    // Retorna o deposito eletrico do hybrid
    public Deposit gethybridEletricalDeposit() {
        return hybridEletricalDeposit;
    }

    // Retorna o deposito fuel do hybrid
    public Deposit getHybridFuelDeposit() {
        return hybridFuelDeposit;
    }
}