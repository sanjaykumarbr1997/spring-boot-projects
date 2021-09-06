package com.xworkz.vaccination.dao;

import java.util.List;

import javax.persistence.NamedQuery;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccination.controller.VaccinationLoginController;
import com.xworkz.vaccination.dto.MemberDetailsDTO;
import com.xworkz.vaccination.entity.MemberDetailsEntity;
import com.xworkz.vaccination.exceptions.DaoException;

@Repository
public class MemberDetailsRegistrationDAOimpl implements MemberDetailsRegistrationDAO {
	private static final Logger logger = Logger.getLogger(MemberDetailsRegistrationDAOimpl.class);

	@Autowired
	private SessionFactory factory;

	public boolean saveDetails(MemberDetailsEntity memberEntity) throws DaoException {
		Session session = null;

		try {
			logger.info("Invoked saveDetails() from MemberDetailsRegistrationDAOimpl");
			session = factory.openSession();
			session.beginTransaction();
			session.save(memberEntity);
			session.getTransaction().commit();
			return true;

		} catch (HibernateException e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
				logger.warn("Error in saving saveDetails() from MemberDetailsRegistrationDAOimpl");
				throw new DaoException("Exception saving in DAO" + e.getMessage());
			}
		} finally {
			if (session != null) {
				session.close();
				logger.info("Session is closed for saveDetails() in MemberDetailsRegistrationDAOimpl ");
			}
		}
		return false;

	}

	@Override
	public List<MemberDetailsEntity> fetchAllDetails() {
		Session session = null;
		try {
			logger.info("Invoked fetchAllDetails() from MemberDetailsRegistrationDAOimpl");
			session = factory.openSession();

			return session.getNamedQuery("fetchAllDetails").list();
		} catch (HibernateException e) {
			if (session.beginTransaction() != null) {
				session.getTransaction().rollback();
				logger.info("Error in getting list from fetchAllDetails() in MemberDetailsRegistrationDAOimpl");
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				logger.info("Session is closed for fetchAllDetails() in MemberDetailsRegistrationDAOimpl ");

			}

		}
		return null;
	}

	@Override
	public void updateNoOfRegistered(String emailOfUser, int noOfRegisteredUsers) {
		Session session = null;
		try {

			logger.info("Invoked updateNoOfRegistered() from MemberDetailsRegistrationDAOimpl");
			session = factory.openSession();
			session.beginTransaction();
			session.getNamedQuery("updateNoOfMembersRegistered").setParameter("membersRegistered", noOfRegisteredUsers)
					.setParameter("emailAdr", emailOfUser).executeUpdate();
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			logger.info("Error in updating updateNoOfRegistered() in MemberDetailsRegistrationDAOimpl");

		} finally {
			if (session != null) {
				session.close();
				logger.info("Session is closed for updateNoOfRegistered() in MemberDetailsRegistrationDAOimpl ");

			}

		}

	}

	public int getUserDetails(String userEmail) {
		Session session = null;
		try {
			logger.info("Invoked getUserDetails() from MemberDetailsRegistrationDAOimpl");

			session = factory.openSession();
			return Integer.parseInt(session.getNamedQuery("getMembersRegistered").setParameter("email", userEmail)
					.uniqueResult().toString());

		} catch (HibernateException e) {
			e.printStackTrace();
			logger.info("Error in getting details from getUserDetails() in MemberDetailsRegistrationDAOimpl");

		} finally {
			if (session != null) {
				session.close();
				logger.info("Session is closed for getUserDetails() in MemberDetailsRegistrationDAOimpl ");

			}

		}
		return 0;
	}

	@Override
	public MemberDetailsEntity getMemberDetails(int id) {
		Session session = null;
		try {
			logger.info("Invoked getMemberDetails() from MemberDetailsRegistrationDAOimpl");

			session = factory.openSession();

			return session.get(MemberDetailsEntity.class, id);

		} catch (HibernateException e) {
			e.printStackTrace();
			logger.info("Error in getting details from getMemberDetails() in MemberDetailsRegistrationDAOimpl");

		} finally {
			if (session != null) {
				session.close();
				logger.info("Session is closed for getMemberDetails() in MemberDetailsRegistrationDAOimpl ");

			}

		}
		return null;
	}

	@Override
	public void updateDetailsByAadhar(String aadharNo, MemberDetailsEntity memberEntity) {
		Session session = null;
		try {
			logger.info("Invoked updateDetailsByAadhar() from MemberDetailsRegistrationDAOimpl");

			session = factory.openSession();
			session.beginTransaction();
			session.getNamedQuery("updateDetailsByAadhar").setParameter("name", memberEntity.getNameOfMember())
					.setParameter("gender", memberEntity.getGenderOfMember())
					.setParameter("aadhar", memberEntity.getAadharOfMember())
					.setParameter("mobile", memberEntity.getMobileNoOfMember())
					.setParameter("type", memberEntity.getTypeOfVaccine()).setParameter("aadharno", aadharNo)
					.executeUpdate();
			session.getTransaction().commit();

		} catch (HibernateException e) {
			session.getTransaction().rollback();
			logger.info("Error in updating details from updateDetailsByAadhar() in MemberDetailsRegistrationDAOimpl");

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				logger.info("Session is closed for updateDetailsByAadhar() in MemberDetailsRegistrationDAOimpl ");

			}

		}
	}

	@Override
	public void deleteDetailsByAadhar(String aadhar) {
		Session session = null;
		try {
			logger.info("Invoked deleteDetailsByAadhar() from MemberDetailsRegistrationDAOimpl");

			session = factory.openSession();
			session.beginTransaction();
			session.getNamedQuery("deleteDetialsByAadhar").setParameter("aadharNumber", aadhar).executeUpdate();
			session.getTransaction().commit();

		} catch (HibernateException e) {
			session.getTransaction().rollback();
			logger.info("Error in deleting details from deleteDetailsByAadhar() in MemberDetailsRegistrationDAOimpl");

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}

	}

}
