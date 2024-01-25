package org.example.jee_hopital.services;

import org.example.jee_hopital.entities.Patient;
import org.example.jee_hopital.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class PatientService extends BaseService implements Repository<Patient> {

    public PatientService(){
        super();
    }

    @Override
    public boolean create(Patient patient) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(patient);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Patient patient) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(patient);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Patient patient) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(patient);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Patient findById(int id) {
        Patient patient = null;
        session = sessionFactory.openSession();
        patient = (Patient) session.get(Patient.class, id);
        session.close();
        return patient;
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patientList = null;
        session = sessionFactory.openSession();
        Query<Patient> patientQuery = session.createQuery("from Patient");
        patientList = patientQuery.list();
        session.close();
        return patientList;
    }
    public List<Patient> filterByDateNaissance(Date min, Date max) throws Exception{
        if(min.before(max)){
            session = sessionFactory.openSession();
            Query<Patient> patientQuery = session.createQuery("from Patient where dateNaissance >= :min and dateNaissance <= :max ");
            patientQuery.setParameter("min",min);
            patientQuery.setParameter("max",max);
            List<Patient> patientList = patientQuery.list();
            session.close();
            return patientList;
        }
        throw new Exception("erreur date");
    }

    public List<Patient> filterByNoms(List<String> noms) throws Exception {
        if(noms.size() > 0) {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query<Patient> patientQuery = session.createQuery("from Patient where nom in :noms");
            patientQuery.setParameter("noms", noms);
            List<Patient> patientList = patientQuery.list();
            session.getTransaction().commit();
            session.close();
            return patientList;
        }
        throw new Exception("aucun nom");
    }

    public boolean deleteByNom(String nom) {

        session = sessionFactory.openSession();

        Query query = session.createQuery("delete Patient where nom = :nom");
        query.setParameter("nom", nom);
        session.getTransaction().begin();
        int success = query.executeUpdate(); // C'est le nombre de ligne affectée par la requete
        session.getTransaction().commit();
        session.close();
        return success > 0;
    }

    public void begin(){
        session = sessionFactory.openSession();
    }

    public void end(){
        sessionFactory.close();
    }
}
