package application;

import java.util.Date;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	public static void main(String[] args) {
		
		Department obj = new Department(1, "Books");
		Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		SellerDAO sellerDAO = DAOFactory.createSellerDAO(); //Uma forma de injeção de dependência para desacoplar o model do acesso jdbc		
		
		System.out.println(seller);
	}
}
