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
                String type = "";
                for (Task task: taskList) {
                    if (task instanceof Todo) {
                        type = "T";
                    }
                    if (task instanceof Deadline) {
                        type = "D";
                    }
                    if (task instanceof Event) {
                        type = "E";
                    }
                    System.out.println(number + "." + String.format("[%s][%s] ", type, task.getStatusIcon())
                            + task.description);
                    number++;
                }
            } else if (command.contains("done")) {
                int position = command.indexOf(" ");
                int rank = Integer.parseInt(command.substring(position+1));
                taskList.get(rank-1).markAsDone();
                System.out.println("Nice! I've marked this task as done:\n" +
                        "[" + taskList.get(rank-1).getStatusIcon() + "] " +
                        taskList.get(rank-1).description);
            } else if (command.contains("delete")) {
                int position = command.indexOf(" ");
                int rank = Integer.parseInt(command.substring(position+1));
                String type = "";
                if (taskList.get(rank-1) instanceof Todo) {
                    type = "T";
                }
                if (taskList.get(rank-1) instanceof Deadline) {
                    type = "D";
                }
                if (taskList.get(rank-1) instanceof Event) {
                    type = "E";
                }
                System.out.println("Noted. I've removed this task:\n" +
                        String.format("[%s][%s] %s", type, taskList.get(rank-1).getStatusIcon(), taskList.get(rank-1).description));
                taskList.remove(rank-1);
                System.out.println("Now you have " + taskList.size() + " tasks in the list.");
            } else if (command.contains("todo")) {
                if (command.equals("todo")) {
                    DukeException dukeException = new DukeException("OOPS!!! The description of a todo cannot be empty");
                    System.out.println(dukeException);
                } else {
                    Todo todo = new Todo(command.substring(command.indexOf(" ") + 1));
                    System.out.println(todo + String.format("[%s][%s] %s", "T",
                            todo.getStatusIcon(), todo.description));
                    taskList.add(todo);
                    System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                }
            } else if (command.contains("deadline")) {
                if (command.equals("deadline")) {
                    DukeException dukeException = new DukeException("OOPS!!! The description of a deadline cannot be empty");
                    System.out.println(dukeException);
                } else {
                    String task = command.substring(command.indexOf(" ") + 1, command.indexOf("/"));
                    task = task + "(by: " + command.substring(command.indexOf("/by") + 4) + ")";
                    Deadline deadline = new Deadline(task);
                    System.out.println(deadline + String.format("[%s][%s] %s", "D",
                            deadline.getStatusIcon(), deadline.description));
                    taskList.add(deadline);
                    System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                }
            } else if (command.contains("event")) {
                if (command.equals("event")) {
                    DukeException dukeException = new DukeException("OOPS!!! The description of an event cannot be empty");
                    System.out.println(dukeException);
                } else {
                    String task = command.substring(command.indexOf(" ") + 1, command.indexOf("/"));
                    task = task + "(at: " + command.substring(command.indexOf("/at") + 4) + ")";
                    Event event = new Event(task);
                    System.out.println(event + String.format("[%s][%s] %s", "E",
                            event.getStatusIcon(), event.description));
                    taskList.add(event);
                    System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                }
            } else {
                DukeException dukeException = new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                System.out.println(dukeException);
            }
            command = scanner.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
