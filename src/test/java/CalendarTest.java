import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ariel on 08/06/2018.
 */
public class CalendarTest {
    @Test
    public void testTimeZonesWithCalendar() throws ParseException {
        Assert.assertEquals(0L, newCalendarInstance("GMT").getTimeInMillis());
        Assert.assertEquals(TimeUnit.HOURS.toMillis(-9), newCalendarInstance("Japan").getTimeInMillis());
        Assert.assertEquals(TimeUnit.HOURS.toMillis(10), newCalendarInstance("Pacific/Honolulu").getTimeInMillis());
        Calendar epoch = newCalendarInstance("GMT");
        epoch.setTimeZone(TimeZone.getTimeZone("Japan"));
        Assert.assertEquals(TimeUnit.HOURS.toMillis(-9), epoch.getTimeInMillis());
    }

    private Calendar newCalendarInstance(String timeZoneId) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, 1970);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.setTimeZone(TimeZone.getTimeZone(timeZoneId));
        return calendar;
    }
}
