package lesson.model;

public abstract class Lesson {

    protected Lesson(String title) {
        this.title = title;
    }

    public abstract int duration();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

}
