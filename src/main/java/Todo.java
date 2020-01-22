public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    public void printTodo(Task task) {
        System.out.println(String.format("[%s][%s] %s", "T",
                task.getStatusIcon(), task.description));
    }

    public String toString() {
        return "Got it. I've added this task:\n";
    }
}
