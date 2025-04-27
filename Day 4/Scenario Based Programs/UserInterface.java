import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserInterface {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BookCabMain object = new BookCabMain();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("Enter number of bookings to be added");
        int n = input.nextInt();

        try {
            System.out.println("Enter the Booking details (Booking ID:Date of booking");
            for (int i = 0; i < n; i++) {

                String user_input = input.next();
                String[] inputDetails = user_input.split(":");
                String BookingID = inputDetails[0];
                Date date = format.parse(inputDetails[1]);
                object.setValue(BookingID, date);
            }

            try {
                System.out.println("Enter the date to check the booking");
                String checkDate = input.next();
                Date searchDate = format.parse(checkDate);

                List<String> searchIDs = object.findCabBookingIdsForTheBookingDate(searchDate);

                if(searchIDs.isEmpty()) {
                    System.out.println("No bookings were booked");
                } else {
                    for (String item : searchIDs) {
                        System.out.println(item);
                    }
                }

            } catch (ParseException e) {
                System.out.println("wrong Date Format");
            }
        } catch (ParseException e) {
            System.out.println("Wrong Date Format");
        }
        input.close();
    }
}
