import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.joda.time.chrono.ISOChronology;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ariel on 08/06/2018.
 */
public class JodaTimeTest {
    @Test
    public void testTimeZonesWithDateTime() throws ParseException {
        assertEquals(0L, newDateTimeMillis("GMT").toDate().getTime());
        assertEquals(TimeUnit.HOURS.toMillis(-9), newDateTimeMillis("Japan").toDate().getTime());
        assertEquals(TimeUnit.HOURS.toMillis(10), newDateTimeMillis("Pacific/Honolulu").toDate().getTime());
        DateTime epoch = newDateTimeMillis("GMT");
        assertEquals("1970-01-01T00:00:00.000Z", epoch.toString());

        System.out.println(epoch.getMillis());

        epoch = epoch.toDateTime(DateTimeZone.forID("Japan"));
        assertEquals(0, epoch.toDate().getTime());
        assertEquals("1970-01-01T09:00:00.000+09:00", epoch.toString());

        System.out.println(epoch.getMillis());

        MutableDateTime mutableDateTime = epoch.toMutableDateTime();
        mutableDateTime.setChronology(ISOChronology.getInstance().withZone(DateTimeZone.forID("Japan")));
        assertEquals("1970-01-01T09:00:00.000+09:00", epoch.toString());
    }

    private DateTime newDateTimeMillis(String timeZoneId) {
        return new DateTime(DateTimeZone.forID(timeZoneId))
                .withYear(1970)
                .withMonthOfYear(1)
                .withDayOfMonth(1)
                .withTimeAtStartOfDay();
    }
}
