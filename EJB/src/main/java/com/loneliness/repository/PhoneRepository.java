package com.loneliness.repository;

import com.loneliness.config.HibernateUtil;
import com.loneliness.entity.Phone;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PhoneRepository implements IPhoneRepository {
    @Override
    public Optional<Phone> findByPriceAndStatus(BigDecimal price, boolean status) {
        return Optional.empty();
    }

    @Override
    public void add(Phone phone) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(phone);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }

    @Override
    public void deletePhoneByCategoryAndModel(String category, String model) {
        Session session = null;
        List<Phone> phones = new ArrayList<Phone>();
        BigDecimal price =new BigDecimal(0);
        boolean status=false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(" from Phone where status = :status and price =:price").
                    setBoolean("status", status).setBigDecimal("price", price);
            phones = (List<Phone>) query.list();
            session.getTransaction().commit();
            for (Phone phone :
                    phones) {
                session.delete(phone);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void deleteByCategoryAndModel(String category, String model) {
        Session session = null;
        List<Phone> phones = new ArrayList<Phone>();
        BigDecimal price =new BigDecimal(0);
        boolean status=false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Phone where status = :status and price =:price").
                    setBoolean("status", status).setBigDecimal("price", price);
            phones = (List<Phone>) query.list();
            session.getTransaction().commit();
            for (Phone phone :
                    phones) {
                session.delete(phone);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List<Phone> getPhonesByStatusAndPrice(boolean status, BigDecimal price) {
        Session session = null;
        List<Phone> phones = new ArrayList<Phone>();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Phone where status = :status and price = : price ").
                    setBoolean("status", status).setBigDecimal("price", price);
            phones = (List<Phone>) query.list();
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return phones;
    }

    @Override
    public List<Phone> getPhonesByIdIsNotNull() {
        Session session = null;
        List phones = new ArrayList<Phone>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            phones = session.createCriteria(Phone.class).list();
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return phones;
    }

    @Override
    public Phone findById(int id) {
        Session session = null;
        Phone bus = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            bus = (Phone) session.load(Phone.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return bus;
    }

    @Override
    public void update(Phone phone) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(phone);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
