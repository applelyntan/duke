public class Event extends Task {

    public Event(String description) {
        super(description);
    }

    public void printEvent(Task task) {
        System.out.println(String.format("[%s][%s] %s", "E",
                task.getStatusIcon(), task.description));
    }

    public String toString() {
        return "Got it. I've added this task:\n";
    }
}
