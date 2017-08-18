package org.itstep.j2_16.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.itstep.j2_16.entity.Student;

public class StudentDaoXml implements StudentDao {
    private SessionFactory sessionFactory;

    public StudentDaoXml() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public List<Student> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        List<Student> students = session.createCriteria(Student.class)
//                .setResultTransformer(DISTINCT_ROOT_ENTITY)
//                .list();

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

        Student saveStudent = (Student) session.merge(student);

        session.getTransaction().commit();
        session.close();

        return saveStudent;
    }
}
