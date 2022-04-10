package application;

import java.util.Date;
import java.util.List;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	public static void main(String[] args) {
		
		SellerDAO sellerDAO = DAOFactory.createSellerDAO(); //Uma forma de inje��o de depend�ncia para desacoplar o model do acesso jdbc
		
		System.out.println("==== Test 1: Seller findById ====");
		Seller seller = sellerDAO.findById(3);
		System.out.println(seller);
		
		System.out.println("\n==== Test 2: Seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDAO.findByDepartment(department);
		for (Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== Test 3: Seller findAll ====");
		list = sellerDAO.findAll();
		for (Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== Test 4: Seller insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDAO.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
	}
}
