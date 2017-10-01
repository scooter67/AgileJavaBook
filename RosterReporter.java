package studentinfo;

public class RosterReporter {
    private CourseSession session;

    /*I don't recall why I decided to make these both static and final
    and there is no doubt I need to do research into full meaning/ramifications of
    said designations*/

    static final String NEWLINE = System.getProperty("line.separator");
    static final String ROSTER_REPORT_HEADER = "Student"+NEWLINE+"----"+NEWLINE;
    static final String ROSTER_REPORT_FOOTER = NEWLINE+"# students = ";

    void RosterReporter(CourseSession session)
    {
        this.session=session;
    }

    String getReport()
    {
        StringBuilder buffer = new StringBuilder();

        buffer.append(ROSTER_REPORT_HEADER);
        for(Student student:session.getStudents())
        {
            buffer.append(student.getName());
            buffer.append(NEWLINE);
        }


        buffer.append(ROSTER_REPORT_FOOTER+session.getNumberOfStudents()+NEWLINE);

        return buffer.toString();
    }
}
