package org.itstep.j2_16.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itstep.j2_16.entity.Student;

public class StudentDaoUniversal implements StudentDao {
    private SessionFactory sessionFactory;

    public StudentDaoUniversal(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Student> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> variableRoot = query.from(Student.class);
        query.select(variableRoot);
        List<Student> students = session.createQuery(query).getResultList();

        session.getTransaction().commit();
        session.close();

        return students;
    }

    @Override
    public Student save(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student savedStudent = (Student) session.merge(student);

        session.getTransaction().commit();
        session.close();

        return savedStudent;
    }
}
