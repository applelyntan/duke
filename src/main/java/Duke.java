import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Applelyn\n" +
                "What can I do for you?");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
        while (!command.equals("bye")) {
            System.out.println(command);
            command = scanner.next();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
