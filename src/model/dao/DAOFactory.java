package model.dao;

import dao.impl.SellerDAOJDBC;

public class DAOFactory {
	
	public static SellerDAO createSellerDAO() {
		return new SellerDAOJDBC();
	}
}
