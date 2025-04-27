import java.text.SimpleDateFormat;
import java.util.*;

public class BookCabMain {
    private HashMap<String, Date> bookingMap = new HashMap<>();

    public void setValue(String bookingID, Date date) {
        bookingMap.put(bookingID, date);
    }

    public HashMap<String, Date> getBookingMap() {
        return bookingMap;
    }

    List<String> findCabBookingIdsForTheBookingDate(Date date) {
        List<String> bookingIDs = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (Map.Entry<String, Date> element : bookingMap.entrySet()) {
            if (format.format(element.getValue()).equals(format.format(date))) {
                bookingIDs.add(element.getKey());
            }
        }
        return bookingIDs;
    }
}
