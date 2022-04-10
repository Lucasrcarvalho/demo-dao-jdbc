package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDAO departmentDAO = DAOFactory.createDepartmentDAO(); //Uma forma de injeção de dependência para desacoplar o model do acesso jdbc
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==== Test 1: Department findById ====");
		Department department = departmentDAO.findById(3);
		System.out.println(department);
		
		System.out.println("\n==== Test 2: Department findAll ====");
		List<Department> list = departmentDAO.findAll();
		for (Department dep: list) {
			System.out.println(dep);
		}
		
		System.out.println("\n==== Test 3: Department insert ====");
		Department newDepartment = new Department(null, "Smartphones");
		departmentDAO.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n==== Test 4: Department update ====");
		department = departmentDAO.findById(8);
		department.setName("Tablets");
		departmentDAO.update(department);
		System.out.println("Update completed!");
		
		System.out.println("\n==== Test 5: Department delete ====");
		System.out.println("Enter id for delete teste: ");
		int id = sc.nextInt();
		departmentDAO.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
