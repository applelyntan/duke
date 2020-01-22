import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Applelyn\n" +
                "What can I do for you?");
        Scanner sc = new Scanner(System.in);
        String command = sc.next();
        while (!command.equals("bye")) {
            System.out.println(command);
            command = sc.next();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
