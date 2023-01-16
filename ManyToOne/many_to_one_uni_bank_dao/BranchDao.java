package many_to_one_uni_bank_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one_uni_bank_dto.Bank;
import many_to_one_uni_bank_dto.Branch;

public class BranchDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	public void insertBranch(Branch branch) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(branch);
		entityTransaction.commit();
		System.out.println("Insertion successfull...!!");
	}
	public void updateBranch(int id,Branch branch) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch recievedBranch = entityManager.find(Branch.class, id);
		if(recievedBranch!=null) {
			branch.setId(id);
			entityTransaction.begin();
			entityManager.merge(branch);
			entityTransaction.commit();
		}
		else {
			System.out.println("Branch not present...!!");
		}
	}
	public void deleteBranch(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch recievedBranch = entityManager.find(Branch.class, id);
		if(recievedBranch!=null) {
			entityTransaction.begin();
			entityManager.remove(recievedBranch);
			entityTransaction.commit();
		}
		else {
			System.out.println("Branch not present...!!");
		}
	}
	public void fetchBranch(int id) {
		EntityManager entityManager = getEntityManager();
		Branch branch = entityManager.find(Branch.class, id);
		System.out.println(branch);
	}
	public void fetchAllBranch() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select b from Branch b");
		List<Branch> list = query.getResultList();
		System.out.println(list);
	}
}