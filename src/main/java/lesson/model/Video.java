package lesson.model;

public class Video extends Lesson {

    public Video(int seconds, String url, String title) {
        super(title);

        this.seconds = seconds;
        this.url = url;
    }

    @Override
    public int duration() {
        return seconds;
    }

    public String getUrl() {
        return url;
    }

    private final int seconds;
    private final String url;

}
