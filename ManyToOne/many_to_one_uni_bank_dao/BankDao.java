package many_to_one_uni_bank_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one_uni_bank_dto.Bank;

public class BankDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	public void insertBank(Bank bank) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(bank);
		entityTransaction.commit();
		System.out.println("Insertion successfull...!!");
	}
	public void updateBank(int id,Bank bank) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Bank recievedBank = entityManager.find(Bank.class, id);
		if(recievedBank!=null) {
			bank.setId(id);
			entityTransaction.begin();
			entityManager.merge(bank);
			entityTransaction.commit();
			System.out.println("Updation successfull...!!");
		}
		else {
			System.out.println("Bank not present...!!");
		}
	}
	public void deleteBank(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Bank bank = entityManager.find(Bank.class, id);
		if(bank!=null) {
			bank.setId(id);
			entityTransaction.begin();
			entityManager.remove(bank);
			entityTransaction.commit();
			System.out.println("Deletion successfull...!!");

		}
		else {
			System.out.println("Bank not present...!!");
		}
	}
	public void fetchBank(int id) {
		EntityManager entityManager = getEntityManager();
		Bank bank = entityManager.find(Bank.class, id);
		System.out.println(bank);
	}
	public void fetchAllBank() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select b from Bank b");
		List<Bank> list = query.getResultList();
		System.out.println(list);
	}
}
