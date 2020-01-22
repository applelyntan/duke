import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Applelyn\n" +
                "What can I do for you?");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<>();
        String command = scanner.nextLine();
        while (!command.equals("bye")) {
            if (command.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                int number = 1;
                for (Task task: taskList) {
                    System.out.println(number + ". [" + task.getStatusIcon()
                            + "] " + task.description);
                    number++;
                }
            } else if (command.contains("done")) {
                int position = command.indexOf(" ");
                int rank = Integer.valueOf(command.substring(position+1));
                taskList.get(rank-1).doneTask();
                System.out.println("Nice! I've marked this task as done:\n" +
                        "[" + taskList.get(rank-1).getStatusIcon() + "] " +
                        taskList.get(rank-1).description);
            } else {
                System.out.println("added: " + command);
                taskList.add(new Task(command));
            }
            command = scanner.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
