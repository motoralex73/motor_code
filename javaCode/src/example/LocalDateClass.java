package example;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class LocalDateClass {

    public static void main(String[] args) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(simpleDateFormat.format(new Date()));

        LocalDate localDate = LocalDate.of(2022,11,22); //now
        localDate.minusDays(5);
        localDate.plusDays(399);
        System.out.println(localDate);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        System.out.println(localDate.format(dateTimeFormatter));

    }
}
