package org.example.jee_hopital.services;

import org.example.jee_hopital.entities.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public abstract class BaseService {

    protected StandardServiceRegistry registre;

    protected SessionFactory sessionFactory;

    protected Session session;

    public BaseService() {
        registre = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();

    }
    public abstract boolean create(Patient o);

    public abstract boolean update(Patient o);
}
