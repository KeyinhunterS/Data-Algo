import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static String[][] seats = new String[5][10]; // 5 rows, 10 seats each

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeSeats();

        while (true) {
            System.out.println("\n Movie Theater Seat Booking System");
            System.out.println("1. View Seating Chart");
            System.out.println("2. Reserve a Seat");
            System.out.println("3. Cancel a Reservation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displaySeatingChart();
                    break;
                case 2:
                    reserveSeat(scanner);
                    break;
                case 3:
                    cancelSeat(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void initializeSeats() {
        for (String[] seat : seats) {
            // O = Open
            Arrays.fill(seat, "O");
        }
    }

    public static void displaySeatingChart() {
        System.out.println("\n   1 2 3 4 5 6 7 8 9 10");
        char rowLetter = 'A';
        for (String[] seat : seats) {
            System.out.print(rowLetter++ + ": ");
            for (String s : seat) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static void reserveSeat(Scanner scanner) {
        System.out.print("Enter seat to reserve (e.g., A5): ");
        String input = scanner.nextLine().toUpperCase();

        int row = input.charAt(0) - 'A';
        int col = Integer.parseInt(input.substring(1)) - 1;

        if (row >= 0 && row < 5 && col >= 0 && col < 10) {
            if (seats[row][col].equals("O")) {
                seats[row][col] = "X";
                System.out.println("Seat " + input + " reserved.");
            } else {
                System.out.println("Seat " + input + " is already taken.");
                suggestSeat();
            }
        } else {
            System.out.println("Invalid seat.");
        }
    }

    public static void suggestSeat() {
        System.out.print("Available seat suggestion: ");
        for (int row = 0; row < seats.length; row++) {
            for (int col = 0; col < seats[row].length; col++) {
                if (seats[row][col].equals("O")) {
                    System.out.println((char) ('A' + row) + "" + (col + 1));
                    return;
                }
            }
        }
        System.out.println("No seats available.");
    }

    public static void cancelSeat(Scanner scanner) {
        System.out.print("Enter seat to cancel (e.g., A5): ");
        String input = scanner.nextLine().toUpperCase();

        int row = input.charAt(0) - 'A';
        int col = Integer.parseInt(input.substring(1)) - 1;

        if (row >= 0 && row < 5 && col >= 0 && col < 10) {
            if (seats[row][col].equals("X")) {
                seats[row][col] = "O";
                System.out.println("Reservation for seat " + input + " canceled.");
            } else {
                System.out.println("Seat " + input + " is not reserved.");
            }
        } else {
            System.out.println("Invalid seat.");
        }
    }
}
