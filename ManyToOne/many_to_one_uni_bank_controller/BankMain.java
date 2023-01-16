package many_to_one_uni_bank_controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import many_to_one_uni_bank_dao.BankDao;
import many_to_one_uni_bank_dao.BranchDao;
import many_to_one_uni_bank_dto.Bank;
import many_to_one_uni_bank_dto.Branch;

public class BankMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch branch = new Branch();
		Bank bank = new Bank();
		BankDao bankDao = new BankDao();
		BranchDao branchDao = new BranchDao();
		boolean condition = true;
		boolean condition1 = true;
		boolean condition2 = true;
		do {
			System.out.println("Press");
			System.out.println("1 : Bank");
			System.out.println("2 : Branch");
			System.out.println("3 : Exit");
			System.out.print("Enter the choice : ");
			int choice = scanner.nextInt();
			switch(choice) {
			case 1 : {
				do {
					System.out.println("1 : Insert bank");
					System.out.println("2 : Update bank");
					System.out.println("3 : Delete bank");
					System.out.println("4 : Fetch single bank");
					System.out.println("5 : Fetch all bank");
					System.out.println("6 : Exit");
					System.out.println("Enter your choice : ");
					int choice1 = scanner.nextInt();
					switch(choice1) {
					case 1 : {
						System.out.println("name : ");
						String name = scanner.next();
						System.out.println("Enter Headoffice : ");
						String headoffice = scanner.next();
						System.out.println("Enter ceo");
						String ceo = scanner.next();
						
						bank.setName(name);
						bank.setHeadOffice(headoffice);
						bank.setCEO(ceo);
						
						bankDao.insertBank(bank);
					}
					break;
					case 2 : {
						System.out.println("Enter id : ");
						int id = scanner.nextInt();
						System.out.println("name : ");
						String name = scanner.next();
						System.out.println("Enter Headoffice : ");
						String headoffice = scanner.next();
						System.out.println("Enter ceo");
						String ceo = scanner.next();
						
						bank.setName(name);
						bank.setHeadOffice(headoffice);
						bank.setCEO(ceo);
						
						bankDao.updateBank(id, bank);
					}
					break;
					case 3 : {
						System.out.println("Enter id : ");
						int id = scanner.nextInt();
						
						bankDao.deleteBank(id);
					}
					break;
					case 4 : {
						System.out.println("Enter id : ");
						int id = scanner.nextInt();
						
						bankDao.fetchBank(id);
					}
					break;
					case 5 : {
						bankDao.fetchAllBank();
					}
					break;
					case 6 : {
						condition1 = false;
					}
					}
				}while(condition1);
				
			}
			break;
			case 2 : {
				do {
					System.out.println("1 : Insert Branch");
					System.out.println("2 : Update Branch");
					System.out.println("3 : Delete Branch");
					System.out.println("4 : Fetch single Branch");
					System.out.println("5 : Fetch all Branch");
					System.out.println("6 : Exit");
					System.out.println("Enter your choice : ");
					int choice2 = scanner.nextInt();
					switch(choice2) {
					case 1 : {
						if(bank.getId()!=0) {
							System.out.print("Enter branch name : ");
							String branchName = scanner.next();
							System.out.print("Enter branch ifsc : ");
							String ifsc = scanner.next();
							System.out.print("Enter branch address : ");
							String branchAddress = scanner.next();
							System.out.print("Enter branch manager name : ");
							String branchManager = scanner.next();
							System.out.print("Enter branch phone number : ");
							long branchPhone = scanner.nextLong();
							System.out.println("name : ");
							String name = scanner.next();
							System.out.println("Enter Headoffice : ");
							String headoffice = scanner.next();
							System.out.println("Enter ceo");
							String ceo = scanner.next();
							
							branch.setAddress(branchAddress);
							branch.setName(branchName);
							branch.setIfsc(ifsc);
							branch.setManager(branchManager);
							branch.setPhone(branchPhone);
							
							bank.setCEO(ceo);
							bank.setName(name);
							bank.setHeadOffice(headoffice);
						}
						else{
							System.out.println("Cannot add a branch without a bank");
						}
					}
					break;
					case 2 : {
						if(branch.getId()!=0) {
							System.out.print("Enter branch id : ");
							int id = scanner.nextInt();
							System.out.print("Enter branch name : ");
							String name = scanner.next();
							System.out.print("Enter branch address : ");
							String address = scanner.next();
							System.out.print("Enter manager name :");
							String manager = scanner.next();
							
							branch.setName(name);
							branch.setAddress(address);
							branch.setManager(manager);
							
							bankDao.updateBank(id, bank);
						}
						else {
							System.out.println("No branch available. Insert a branch details first...");
						}
						
					}
					break;
					case 3 : {
						System.out.println("Enter id : ");
						int id = scanner.nextInt();
						
						branchDao.deleteBranch(id);
					}
					break;
					case 4 : {
						System.out.println("Enter id : ");
						int id = scanner.nextInt();
						
						branchDao.fetchBranch(id);
					}
					break;
					case 5 : {
						branchDao.fetchAllBranch();
					}
					break;
					case 6 : {
						condition2 = false;
					}
					}
				}while(condition2);
			}
			break;
			case 3 : {
				condition=false;
			}
			}
		}while(condition);
		
	}

}
