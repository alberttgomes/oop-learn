package lesson;

import lesson.model.Lesson;
import lesson.model.Task;
import lesson.model.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LessonMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many classes have the course?");
        int numberOfCourses = scanner.nextInt();
        scanner.nextLine();

        List<Lesson> lessons = new ArrayList<>();

        for (int i = 1; i <= numberOfCourses; i++) {
            System.out.println("Course's data " + i);

            System.out.print("Content or task? (c/t) ");
            char command = scanner.nextLine().charAt(0);

            System.out.print("Title: ");
            String title = scanner.nextLine();

            if (command == 'c') {
                System.out.print("Video's URL: ");
                String videoUrl = scanner.nextLine();
                System.out.print("Duration in seconds: ");
                int durationInSeconds = scanner.nextInt();

                lessons.add(new Video(durationInSeconds, videoUrl, title));
            }
            else if (command == 't') {
                System.out.print("Description: ");
                String description = scanner.nextLine();
                System.out.print("Question quantity: ");
                int questionQuantity = scanner.nextInt();

                lessons.add(new Task(description, questionQuantity, title));
            }
            else throw new RuntimeException("Invalid command");

            scanner.nextLine();
        }

        System.out.printf(
            "Total course duration = %s seconds",  _totalDuration(lessons));
    }

    private static int _totalDuration(List<Lesson> lessons) {
        int totalDuration = 0;

        for (Lesson lesson : lessons) {
            totalDuration += lesson.duration();
        }

        return totalDuration;
    }

}
