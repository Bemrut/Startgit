package org.itstep.j2_16;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.itstep.j2_16.entity.Student;
import org.itstep.j2_16.service.StudentService;
import org.itstep.j2_16.service.StudentServiceNoXml;
import org.itstep.j2_16.service.StudentServiceXml;
import org.itstep.j2_16.util.HrDepartment;

import static java.util.Arrays.stream;
import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.join;

public class App {

    public static void main(String[] args) {
        System.out.println("== START ==");

        System.out.println("-- Program arguments: -");

//        // creating anonymous class implementing Consumer interface without using keyword 'implement'
//        Consumer<String> stringConsumer_1 = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println("v_1: " + s);
//            }
//        };
//        stream(args).forEach(stringConsumer_1);
//
//        Consumer<String> stringConsumer_2 = (s) -> {
//            System.out.println("v_2: " + s);
//        };
//        stream(args).forEach(stringConsumer_2);
//
//        stream(args).forEach(arg -> {
//            System.out.println("v_3: " + arg);
//        });
        stream(args).forEach(arg -> System.out.println("v_3: " + arg));

        System.out.println("-- JVM arguments --");
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> {
            System.out.println(join(key, value, ": "));
        });

        StudentService studentService;
        String is_xml = System.getProperty("is_xml");
        if (isEmpty(is_xml) || is_xml.equals("false")) {
            studentService = new StudentServiceNoXml();
            System.out.println("-- run NO xml --");
        } else {
            studentService = new StudentServiceXml();
            System.out.println("-- run xml --");
        }
        HrDepartment hrDepartment = new HrDepartment(studentService);

        List<Student> studentsForSaving = new ArrayList<>();
        studentsForSaving.add(new Student("Oleh", "Pinta"));
        studentsForSaving.add(new Student("Alex", "Kochetyga"));
        studentsForSaving.add(new Student("Igor", "Demennikov"));

        for (Student student : studentsForSaving) {
            Student savedStudent = hrDepartment.saveStudent(student);
            System.out.println("Saved student: " + savedStudent.getFullName());
        }
        List<Student> students = hrDepartment.getAllStudents();
        System.out.println("Students got: " + students.size());

        System.out.println("== END ==");
    }
}
