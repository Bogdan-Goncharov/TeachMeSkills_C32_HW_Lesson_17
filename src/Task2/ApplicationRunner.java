package Task2;

import Task2.impl.GenericFunction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.DayOfWeek;
import java.util.Scanner;

public class ApplicationRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a date in YYYY-MM-DD format:");
        String inputDate = scanner.nextLine();

        GenericFunction<String> getDayOfWeek = () -> {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(inputDate, formatter);
                DayOfWeek dayOfWeek = localDate.getDayOfWeek();
                return dayOfWeek.toString();
            } catch (DateTimeParseException e) {
                return "Invalid date format.";
            }
        };

        String dayOfWeek = getDayOfWeek.day();
        System.out.println("Day of the week: " + dayOfWeek);
    }
}



