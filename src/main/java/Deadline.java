public class Deadline extends Task {

    public Deadline(String description) {
        super(description);
    }

    public void printDeadline(Task task) {
        System.out.println(String.format("[%s][%s] %s", "D",
                task.getStatusIcon(), task.description));
    }

    public String toString() {
        return "Got it. I've added this task:\n";
    }
}
