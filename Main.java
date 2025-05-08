import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many days of temperatures? ");
        int numDays = scanner.nextInt(); // e.g., 5

        int[] temps = new int[numDays];

        int sum = 0;
        for (int i =0; i < numDays; i++) {
            System.out.print("Enter temperature for day " + (i + 1) + ":");
            temps[i] = scanner.nextInt(); //input a temperature
            sum += temps[i]; //Keep adding for average
        }

        double average = (double) sum / numDays;
        System.out.println("Average temperature: " + average);

        int aboveAverageCount = 0;
        for (int temp : temps) {
            if (temp > average) {
               aboveAverageCount++;
            }
        }

        System.out.println("Number of days above average: " + aboveAverageCount);

        scanner.close();
    }
}