import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoList {
    private final List<String> tasks;
    private final Scanner scanner;

    public ToDoList() { //metoda
        tasks = new ArrayList<>();           // tip[] numeArray = new tip[dimensiune]; -nu avem o dimensiune setata! -tip(string)
        scanner = new Scanner(System.in);    // intrare consola/ date citite de la tastatura
    }

    private void run() {
        boolean running = true;         // cat este true, va executa
        while (running) {               //bucla
            System.out.println("\n---------- TO DO LIST   --------");   // \n move to the next line!
            System.out.println("1. Add task");
            System.out.println("2. Delete task");
            System.out.println("3. View all tasks");
            System.out.println("4. markTaskAsCompleted");
            System.out.println("5. Quit");
            System.out.print("\nEnter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private void addTask() {
        System.out.print("\nEnter task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully");
    }

    private void deleteTask() {
        System.out.print("\nEnter number to delete: ");
        int taskNum = scanner.nextInt();
        scanner.nextLine();
        if (taskNum > 0 && taskNum <= tasks.size()) {
            tasks.remove(taskNum - 1);
            System.out.println("Task deleted successfully");
        } else {
            System.out.println("Invalid number");
        }
    }

    private void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.run();
    }
}