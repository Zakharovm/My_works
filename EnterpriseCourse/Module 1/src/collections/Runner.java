package collections;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Long> data = new TreeMap<>();
        EfficiencyCalculator calculator = new EfficiencyCalculator();

        System.out.println("Input the quantity of elements: ");
        int input = scanner.nextInt();
        System.out.println(input + " elements in the collection");
        System.out.println("====================================");
        System.out.println("Collection  | Add  | Contains |  Get  | Iterator.add() | Iterator.remove() | Populate | Remove |");
        System.out.print("==============================================================================================");
        calculator.printTable(calculator.countArrayList(data, input), "ArrayList", input);
        data = new TreeMap<>();
        calculator.printTable(calculator.countLinkedList(data, input),"LinkedList", input);
        data = new TreeMap<>();
        calculator.printTable(calculator.countHashSet(data, input),"HashSet", input);
        data = new TreeMap<>();
        calculator.printTable(calculator.countTreeSet(data, input),"TreeSet", input);

        System.out.println("\n==============================================================================================");
    }
}
