package com.xworkz.vaccination.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccination.exceptions.DaoException;

@Repository
public class OtpDAOImpl implements OtpDAO {
	private static final Logger logger = Logger.getLogger(OtpDAOImpl.class);

	@Autowired
	private SessionFactory factory;

	public String verifyEmail(String email) throws DaoException {
		Session session = null;
		try {
			logger.info("Invoked verifyEmail() from OtpDAOImpl");

			session = factory.openSession();
			return (String) session.getNamedQuery("verifyEmail").setParameter("emailID", email).uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			logger.warn("Error in  verifyEmail() from OtpDAOImpl");

			throw new DaoException("Exception saving in DAO" + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
				logger.info("Session is closed for verifyEmail() in OtpDAOImpl");

			}
		}
	}

}
