package com.xworkz.vaccination.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccination.entity.VaccinationEntity;
import com.xworkz.vaccination.exceptions.DaoException;

@Repository
public class VaccinationEnrollDAOImpl implements VaccinationEnrollDAO {
	private static final Logger logger = Logger.getLogger(VaccinationEnrollDAOImpl.class);

	@Autowired
	private SessionFactory factory;

	@Override
	public boolean saveDetails(VaccinationEntity vaccinationEntity) throws DaoException {
		Session session = null;

		try {
			logger.info("Invoked saveDetails() from VaccinationEnrollDAOImpl");

			session = factory.openSession();
			session.beginTransaction();
			session.save(vaccinationEntity);
			session.getTransaction().commit();
			return true;

		} catch (HibernateException e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
				logger.warn("Error in  saveDetails() from VaccinationEnrollDAOImpl");

				throw new DaoException("Exception saving in DAO" + e.getMessage());

			}
		} finally {
			if (session != null) {
				session.close();
				logger.info("Session is closed for saveDetails() in VaccinationEnrollDAOImpl");

			}
		}

		return false;
	}

}
