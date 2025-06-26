package lesson.model;

public class Task extends Lesson {

    public Task(
        String description, int questionCount, String title) {
        super(title);

        this.description = description;
        this.questionCount = questionCount;
    }

    @Override
    public int duration() {
        return (5 * 60) * questionCount;
    }

    public String description() {
        return description;
    }

    private final String description;
    private final int questionCount;

}
