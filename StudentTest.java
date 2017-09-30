package studentinfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class StudentTest {


    @Test
    void nameTest() {
        //Student student = new Student("Jane Doe");
        //String studentName = student.getName();
        //assertEquals("Jane Doe", studentName);

        Student student2= new Student("Joe Blow");
        Assertions.assertEquals("Joe Blow",student2.getName());

    }
}
