package com.xworkz.vaccination.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccination.entity.VaccinationEntity;
import com.xworkz.vaccination.exceptions.DaoException;

@Repository
public class VaccinationLoginDAOImpl implements VaccinationLoginDAO {
	private static final Logger logger = Logger.getLogger(VaccinationLoginDAOImpl.class);

	@Autowired
	private SessionFactory factory;

	@Override
	public VaccinationEntity verify(String email) throws DaoException {
		Session session = null;
		try {
			logger.info("Invoked verify() from VaccinationLoginDAOImpl");

			session = factory.openSession();
			return (VaccinationEntity) session.getNamedQuery("verify").setParameter("emailid", email).uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			logger.warn("Error in  verify() from VaccinationLoginDAOImpl");

			throw new DaoException("Exception saving in DAO" + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
				logger.info("Session is closed for verify() in VaccinationLoginDAOImpl");

			}
		}
	}

	@Override
	public void updateAttempt(int noOfUnsuccesfulLoginAttemp, String email) throws DaoException {
		Session session = null;
		try {
			logger.info("Invoked updateAttempt() from VaccinationLoginDAOImpl");
			session = factory.openSession();
			session.beginTransaction();
			session.getNamedQuery("updateNoOfLoginAttempByEmail").setParameter("login", noOfUnsuccesfulLoginAttemp)
					.setParameter("emailId", email).executeUpdate();
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			logger.warn("Error in  updateAttempt() from VaccinationLoginDAOImpl");

			throw new DaoException("Exception saving in DAO" + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
				logger.info("Session is closed for updateAttempt() in VaccinationLoginDAOImpl");

			}

		}

	}

	public int getUnsuccessfulAttempt(String email) throws DaoException {
		Session session = null;
		try {
			logger.info("Invoked getUnsuccessfulAttempt() from VaccinationLoginDAOImpl");

			session = factory.openSession();
			return Integer.parseInt(session.getNamedQuery("getUnsuccessfulAttempt").setParameter("email", email)
					.uniqueResult().toString());

		} catch (HibernateException e) {
			e.printStackTrace();
			logger.warn("Error in  getUnsuccessfulAttempt() from VaccinationLoginDAOImpl");

			throw new DaoException("Exception saving in DAO" + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
				logger.info("Session is closed for getUnsuccessfulAttempt() in VaccinationLoginDAOImpl");

			}

		}
	}

}
