import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Expense {
    String description;
    double amount;
    String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }
}

public class ExpenseTracker {
    private static List<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Expense Tracker");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addExpense(Scanner scanner) {
        System.out.print("Enter expense description: ");
        String description = scanner.nextLine();
        System.out.print("Enter expense amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter expense category: ");
        String category = scanner.nextLine();

        Expense expense = new Expense(description, amount, category);
        expenses.add(expense);
        System.out.println("Expense added successfully!");
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to display.");
            return;
        }

        System.out.println("Expense List:");
        for (Expense expense : expenses) {
            System.out.println("Description: " + expense.description);
            System.out.println("Amount: $" + expense.amount);
            System.out.println("Category: " + expense.category);
            System.out.println();
        }
    }
}
