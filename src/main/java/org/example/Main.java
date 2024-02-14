package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

    /*    Query query=session.createQuery("from Student where name=?1");
        query.setParameter(1,"Loshani");
        Student student= (Student) query.uniqueResult();
        System.out.println(student.getName());*/

    /*    Query query=session.createQuery("select id,name from Student where id=?1");
        query.setParameter(1,1);
        Object[] object= (Object[]) query.uniqueResult();
        for (Object o : object) {
            System.out.println(o.toString());
        }*/

        Query query= session.createQuery("select id,name from Student");
        List<Object[]> resultList=query.list();

        for (Object[] objects: resultList) {
            for (Object o : objects) {
                System.out.println(o.toString());
            }

        }

        transaction.commit();
        session.close();
    }
}
