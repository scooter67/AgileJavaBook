package studentinfo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static studentinfo.CourseSessionTest.createDate;

public class TestRosterReport {

    @Test
    void testRosterReport()
    {
        CourseSession session = new CourseSession("ENGL","101",createDate(2003,1,6));
        session.enroll(new Student("A"));
        session.enroll(new Student("B"));


        /*TODO: Crazy.  Is complaining RosterReporter Constructor doesn't take a CourseSession Object
         where
             void RosterReporter(CourseSession session)
         is its definition.
        */

        String rosterReport = new RosterReporter(session).getReport();
        assertEquals(
            RosterReporter.ROSTER_REPORT_HEADER+
            "A"+RosterReporter.NEWLINE+
            "B"+RosterReporter.NEWLINE+
            RosterReporter.ROSTER_REPORT_FOOTER+"2"+
            RosterReporter.NEWLINE,rosterReport
        );
    }

    static Date createDate(int year, int month, int date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, date);
        return calendar.getTime();
    }
}
