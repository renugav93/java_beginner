import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class EmployeeAttendance {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            DateTimeFormatter format =
                    DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm");

            System.out.print(
                "Enter login date and time (dd/MM/yyyy HH:mm): "
            );
            String loginText = sc.nextLine();

            LocalDateTime login =
                    LocalDateTime.parse(loginText, format);

            System.out.print(
                "Enter logout date and time (dd/MM/yyyy HH:mm): "
            );
            String logoutText = sc.nextLine();

            LocalDateTime logout =
                    LocalDateTime.parse(logoutText, format);

            // Reject invalid dates that were automatically adjusted
            if (!login.format(format).equals(loginText) ||
                !logout.format(format).equals(logoutText)) {

                System.out.println("Enter valid dates and times.");
                return;
            }

            if (logout.isBefore(login)) {
                System.out.println(
                    "Logout cannot be before login."
                );
                return;
            }

            Duration worked = Duration.between(login, logout);

            long totalMinutes = worked.toMinutes();
            long hours = totalMinutes / 60;
            long minutes = totalMinutes % 60;

            System.out.println(
                "\nTime worked: " + hours + " hour(s) and "
                + minutes + " minute(s)"
            );

            if (totalMinutes >= 8 * 60) {
                System.out.println("Employee worked for at least 8 hours.");
                System.out.println("Attendance approved.");
            } else {
                System.out.println("Employee worked for less than 8 hours.");
                System.out.println("Attendance not approved.");
            }

        } catch (DateTimeParseException e) {
            System.out.println(
                "Invalid input. Use dd/MM/yyyy HH:mm."
            );
        }
    }
}
