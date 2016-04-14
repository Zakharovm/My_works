package multiThreading;

public class Elevator {
    private static int weight = 0;

    public static void addWeight(int number){
        weight += number;
    }

    public static void reduceWeight(int number){
        weight -= number;
    }

    public static int getWeight(){
        return weight;
    }
}
