package application;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Seller;

public class Program {
	
	public static void main(String[] args) {
		
		SellerDAO sellerDAO = DAOFactory.createSellerDAO(); //Uma forma de injeção de dependência para desacoplar o model do acesso jdbc
		
		System.out.println("==== Test 1: Seller findById ====");
		Seller seller = sellerDAO.findById(3);
		System.out.println(seller);
	}
}
