import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class HotelBilling {

    public static void main(String[] args) {

        final int RATE_PER_DAY = 1000;

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter customer name: ");
            String name = sc.nextLine().stripTrailing();

            if (name.isBlank()) {
                System.out.println("Customer name cannot be empty.");
                return;
            }

            DateTimeFormatter format =
                    DateTimeFormatter.ofPattern("dd-MM-uuuu HH:mm");

            System.out.print(
                "Enter check-in (dd-MM-yyyy HH:mm): "
            );
            String inText = sc.nextLine();

            LocalDateTime checkIn =
                    LocalDateTime.parse(inText, format);

            System.out.print(
                "Enter check-out (dd-MM-yyyy HH:mm): "
            );
            String outText = sc.nextLine();

            LocalDateTime checkOut =
                    LocalDateTime.parse(outText, format);

            // Reject dates that were automatically adjusted
            if (!checkIn.format(format).equals(inText) ||
                !checkOut.format(format).equals(outText)) {

                System.out.println("Enter valid dates and times.");
                return;
            }

            if (!checkOut.isAfter(checkIn)) {
                System.out.println(
                    "Check-out must be after check-in."
                );
                return;
            }

            // Total duration of stay
            Duration stay = Duration.between(checkIn, checkOut);

            long totalMinutes = stay.toMinutes();

            long days = totalMinutes / 1440;
            long hours = (totalMinutes % 1440) / 60;
            long minutes = totalMinutes % 60;

            // Count nights using the dates at midnight
            long nights = Duration.between(
                checkIn.toLocalDate().atStartOfDay(),
                checkOut.toLocalDate().atStartOfDay()
            ).toDays();

            // Any extra time is charged as another day
            long billableDays = days;

            if (totalMinutes % 1440 != 0) {
                billableDays++;
            }

            long totalBill = billableDays * RATE_PER_DAY;

            System.out.println("\n------- HOTEL BILL -------");
            System.out.println("Customer name : " + name);
            System.out.println("Check-in      : " + inText);
            System.out.println("Check-out     : " + outText);

            System.out.println(
                "Stay duration : " + days + " day(s), "
                + hours + " hour(s), "
                + minutes + " minute(s)"
            );

            System.out.println("Nights        : " + nights);
            System.out.println("Billable days : " + billableDays);
            System.out.println("Rate per day  : Rs. " + RATE_PER_DAY);
            System.out.println("Total bill    : Rs. " + totalBill);

        } catch (DateTimeParseException e) {
            System.out.println(
                "Invalid input. Use dd-MM-yyyy HH:mm."
            );
        }
    }
}
