
/**
 * Write a description of class Deposit here.
 *
 * @author: Tiago Ramada(202200354) & Bernardo Vaz(202200278)
 * @email: Tiago(202200354@estudantes.ips.pt)
 *         Bernardo(202200278@estudantes.ips.pt)
 * @version 1
 */
public class Deposit
{
    // instance variables
    private int capacity, level;
    /**
     * Constructor for objects of class Deposit
     */
    public Deposit(int capacity, int level)
    {
        // initialise instance variables
        this.capacity = capacity;
        this.level = level;
    }

    // Atestar na totalidade
    public void fullFill(){
        level = capacity;
    }

    // Atestar um determinado valor de carga/gasolina
    public void fill(double value){
        if((level+value)>capacity){
            level = capacity;
        } else {
            level += value;
        }
    }

    // Verificar se está cheio
    public boolean isFull(){
        if(level == capacity){
            return true;
        } else {
            return false;
        }
    }

    // Atualiza o nível do deposito
    public void updateLevel(int newLevel){
        if(newLevel <= capacity){
            level = newLevel;
        } else {
            level = capacity;
        }
    }

    // Retorna a capacidade
    public int getCapacity(){
        return capacity;
    }
    // Retorna o nivel do deposito
    public int getLevel(){
        return level;
    }
}
