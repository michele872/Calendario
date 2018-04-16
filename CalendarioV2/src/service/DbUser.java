package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.User;

public class DbUser {
	
	public static User getUserById (int userId) {
		EntityManager em = DbUtil.getEntityManager("calendario");
		User user = em.find(User.class, userId);
		return user;
	}
	
	public static User getUserByEmail(String email) {
		EntityManager em = DbUtil.getEntityManager("calendario");
		String qString = "Select u from User u where u.email = :email";
		TypedQuery<User> q = em.createQuery(qString, User.class);
		q.setParameter("email", email);
		User user = null;
		try {
			System.out.println("Getting single user");
			user = q.getSingleResult();
			System.out.println(user);
		} catch (Exception e) {
			user = null;
		} finally {
			em.close();
		}
		return user;
	}
	
	public static List<User> getAllUsers() {
		EntityManager em = DbUtil.getEntityManager("calendario");
		String qString = "select u from User u";
		List<User> users = null;
		try {
			TypedQuery<User> q = em.createQuery(qString, User.class);
			users = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return users;
	}
	
	public static void insert(User user) {
		EntityManager em = DbUtil.getEntityManager("calendario");
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(user);
			trans.commit();
		} catch(Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static void update (User user) {
		EntityManager em = DbUtil.getEntityManager("calendario");
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static void delete(User user) {
		EntityManager em = DbUtil.getEntityManager("calendario");
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(user));
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static boolean isValidUser(String email, String password) {
		EntityManager em = DbUtil.getEntityManager("calendario");
		String qString = "Select count(u.idUser) from User u where u.email = :email and u.password = :password";
		TypedQuery<Long> q = em.createQuery(qString, Long.class);
		boolean result = false;
		q.setParameter("email", email);
		q.setParameter("password", password);
		try {
			long idUser = q.getSingleResult();
			if(idUser > 0) {
				result = true;
			}
		} catch (Exception e) {
			result = false;
		} finally {
			em.close();
		}
		return result;
	}
	
	
//	public static void main (String[] args) {
//		System.out.println(getUserById(1).getNome());
//		System.out.println(isValidUser("michele@mic.it", "password"));
//	}
	
}
