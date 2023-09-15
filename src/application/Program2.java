package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Test 1: Department findById ===");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("\n=== Test 2: Seller findAll ===");
        List <Department> list = departmentDao.findAll();
        for (Department obj :list) {
            System.out.println(obj);
        }

        System.out.println("\n=== Test 3: Department insert ===");
        Department newId = new Department(null, "SmartTV");
        departmentDao.insert(newId);
        System.out.println("Inserted! New id = " + newId.getId());

        System.out.println("\n=== TEST 4: Department update ===");
        department = departmentDao.findById(10);
        department.setName("Movies");
        departmentDao.update(department);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 5: Department delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");

        sc.close();
    }
}