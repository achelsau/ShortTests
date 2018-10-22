import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * Created by ariel on 11/06/2018.
 */
public class DateTimeTest {
    public static void main(String[] args) {
        Date sourceDate = new Date();
        DateTime sourceDateWithoutTz = new DateTime(sourceDate).toDateTimeISO();
        System.out.println(sourceDateWithoutTz.toString());

        DateTime sourceDateWithDifferentTZ = new DateTime(sourceDate, DateTimeZone.forID("America/Los_Angeles")).toDateTimeISO();
        System.out.println(sourceDateWithDifferentTZ.toString());

        Calendar cal = Calendar.getInstance();
        cal.setTime(sourceDate);
        DateTime sourceDateWithDifferentTZ2 = new DateTime(DateTimeZone.forID("America/Los_Angeles")).withYear(
                cal.get(Calendar.YEAR)).withMonthOfYear(cal.get(Calendar.MONTH)).withDayOfMonth(
                cal.get(Calendar.DAY_OF_MONTH)).withHourOfDay(cal.get(Calendar.HOUR_OF_DAY)).withMinuteOfHour(
                cal.get(Calendar.MINUTE)).toDateTimeISO();
        System.out.println(sourceDateWithDifferentTZ2.toString());
    }
}
