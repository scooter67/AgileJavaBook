

package studentinfo;

import java.util.*;



/**
 *
 *  Provides a representation of a single semester
 *  session of a specific university course.
 *  @author Administrator
 */


// Everything is so public because I've been playing with Javadoc
// All javadoc here is known to be silly...


public class CourseSession {

    /**
     * Constructs a CourseSession starting on a specific date
     *
     * @param startDate the date on which the CourseSession begins
     */

    static final String NEWLINE = System.getProperty("line.separator");
    private java.util.ArrayList<Student> students = new java.util.ArrayList<Student>();
    private String department;
    private String number;
    private Date startDate;
    static final String ROSTER_REPORT_HEADER = "Student"+NEWLINE+"----"+NEWLINE;
    static final String ROSTER_REPORT_FOOTER = NEWLINE+"# students = ";

    public CourseSession(String department,String number,Date startDate) {
        this.department = department;
        this.number = number;
        this.startDate=startDate;
    }

    public String getDepartment() {
        return department;
    }

    public String getNumber() {
        return number;
    }

    public int getNumberOfStudents() {
        return students.size();
    }


    public void enroll(Student student) {
        students.add(student);
    }

    public Student get(int index)
    {
        return students.get(index);
    }

    public ArrayList<Student> getStudents()
    {
        return students;
    }

    public Date getEndDate() {


        /**
         *  @return Date the last date of the course session
         */




        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        int numberOfDays = (16 * 7) - 3;          // Weeks per term * days per week - three days
        calendar.add(Calendar.DAY_OF_YEAR,numberOfDays);
        Date endDate = calendar.getTime();
        return endDate;
    }

    Date getStartDate()
    {
        return startDate;
    }

    String getRosterReport()
    {

        StringBuilder buffer = new StringBuilder();

        buffer.append(ROSTER_REPORT_HEADER);
        for(Student student:students)
        {
            buffer.append(student.getName());
            buffer.append(NEWLINE);
        }


        buffer.append(ROSTER_REPORT_FOOTER+students.size()+NEWLINE);

        return buffer.toString();

    }

}




