package org.itstep.j2_16.service;

import java.util.List;
import org.itstep.j2_16.dao.StudentDao;
import org.itstep.j2_16.dao.StudentDaoXml;
import org.itstep.j2_16.entity.Student;

public class StudentServiceXml implements StudentService {
    private StudentDao studentDao;

    public StudentServiceXml() {
        this.studentDao = new StudentDaoXml();
    }

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }
}
