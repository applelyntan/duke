import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Applelyn\n" +
                "What can I do for you?");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> textList = new ArrayList<>();
        String command = scanner.nextLine();
        while (!command.equals("bye")) {
            if (command.equals("list")) {
                int number = 1;
                for (String text: textList) {
                    System.out.println(number + ". "
                    + text);
                    number++;
                }
            } else {
                System.out.println("added: " + command);
                textList.add(command);
            }
            command = scanner.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
