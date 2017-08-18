package org.itstep.j2_16.service;

import java.util.List;
import org.itstep.j2_16.entity.Student;

public interface StudentService {

    List<Student> getAll();

    Student save(Student student);
}
