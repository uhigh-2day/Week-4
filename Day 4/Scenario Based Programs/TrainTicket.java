import java.util.ArrayList;
import java.util.Scanner;

public class TrainTicket {

    private static boolean checkLength(String ID) {
        return (ID.length() == 10);
    }

    private static int seatBooked(String ID) {
        int seat_count;
        try {
            seat_count = Integer.parseInt(ID.substring(5, 7));
            if (seat_count > 0 && seat_count <= 10) {
                return seat_count;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Count");
        }
        return -1;
    }

    private static char coachName(String ID) {
        return ID.charAt(7);
    }

    private static ArrayList<Integer> seatNumber(String ID, int seat_count) {
        ArrayList<Integer> seatNumber = new ArrayList<>();
        try {
            int first_seat = Integer.parseInt(ID.substring(8, 10));

            while (seat_count != 0) {
                seatNumber.add(first_seat++);
                seat_count--;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Seat Number");
        }

        return seatNumber;
    }

    public static void validate(String ID) {
        boolean length = checkLength(ID);
        ArrayList<Integer> seat_Number;
        char coachName;

        if (length) {
            int seat_count = seatBooked(ID);
            if (seat_count != -1) {
                coachName = coachName(ID);
                seat_Number = seatNumber(ID, seat_count);
            } else {
                return;
            }
        } else {
            System.out.println("Invalid Input");
            return;
        }
        for (int seat : seat_Number) {
            System.out.println(coachName+""+seat);
        }
    }
}

class TrainTicketMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String ticketID = input.next();
        TrainTicket.validate(ticketID);

        input.close();
    }
}