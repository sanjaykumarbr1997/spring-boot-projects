package com.xworkz.vaccination.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccination.exceptions.DaoException;

@Repository
public class ResetDAOImpl implements ResetDAO {
	private static final Logger logger = Logger.getLogger(ResetDAOImpl.class);

	@Autowired
	private SessionFactory factory;

	@Override
	public boolean updatePassword(String email, String password) {
		Session session = null;
		try {
			logger.info("Invoked updatePassword() from ResetDAOImpl");
			session = factory.openSession();
			session.beginTransaction();
			session.getNamedQuery("updatePassword").setParameter("passw", password).setParameter("emailAddress", email)
					.executeUpdate();
			session.getTransaction().commit();

			return true;

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			logger.warn("Error in  updatePassword() from ResetDAOImpl");

		} finally {
			if (session != null) {
				session.close();
				logger.info("Session is closed for updatePassword() in ResetDAOImpl");

			}

		}
		return false;
	}

	@Override
	public boolean updateUnsucessfulLoginAttempt(String email, int noOfUnsuccesfulAttempts) {
		Session session = null;
		try {
			logger.info("Invoked updateUnsucessfulLoginAttempt() from ResetDAOImpl");

			session = factory.openSession();
			session.beginTransaction();
			session.getNamedQuery("updateUnsucessfulLoginAttempt").setParameter("loginAttempt", noOfUnsuccesfulAttempts)
					.setParameter("emailAddress", email).executeUpdate();
			session.getTransaction().commit();

			return true;

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			logger.warn("Error in  updateUnsucessfulLoginAttempt() from ResetDAOImpl");

		} finally {
			if (session != null) {
				session.close();
				logger.info("Session is closed for updateUnsucessfulLoginAttempt() in ResetDAOImpl");

			}

		}
		return false;
	}

}
