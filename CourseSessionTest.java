package studentinfo;

import static org.junit.jupiter.api.Assertions.assertEquals;    //wacky junit5
import org.junit.jupiter.api.*;

import studentinfo.CourseSession;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



public class CourseSessionTest {

    static private CourseSession session;
    static private Date startDate;


    static Date createDate(int year, int month, int date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, date);
        return calendar.getTime();
    }

  /* Note that we cannot rely on test order, the best I understand
   So this gets run before every test ~ Enrolling students test and report
   test aren't using the same session values.
  */

    @BeforeEach
     void createCourse() {

        startDate = createDate(2003, 1, 6);
        session = new CourseSession("ENGL", "101", startDate);

        System.out.println("Create Course running.");

    }


   @Test
   @DisplayName("Enroll two students")
    void testEnrollStudents() {
        Student student1 = new Student("Cain DiVoe");
        session.enroll(student1);
        assertEquals(1, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));

        Student student2 = new Student("Coralee DeVaughn");
        session.enroll(student2);
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(student2, session.get(1));

        System.out.println("Test by enrolling students");
    }




    @Test
    @DisplayName("Test start and end dates")
    void testCourseDates() {

        Date startDate = createDate(2003, 1, 6);
        Date sixteenWeeksOut = createDate(2003, 4, 25);
        assertEquals(startDate, session.getStartDate());
        assertEquals(sixteenWeeksOut, session.getEndDate());
        System.out.println("Test Course start and end dates");

    }



    @Test
    @DisplayName("Create ENGL")
    void testCreate() {
        assertEquals("ENGL", session.getDepartment());
        assertEquals("101", session.getNumber());

        // How does it choose test order?
        assertEquals(0, session.getNumberOfStudents());
        assertEquals(startDate, session.getStartDate());
        System.out.println("Create ENGL");
    }

}



