package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;


public class ProgramDepartment {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDAO departmentDAO = DaoFactory.createDepartmentDAO();

        System.out.println("===== TEST 1: DEPARTMENT BY Id ====");
        Department department = departmentDAO.findById(1);
        System.out.println(department);

        System.out.println("\n");
        System.out.println("===== TEST 2: DEPARTMENT findByALL ====");
        Department department1 = new Department(5,null);
        List<Department> departments = departmentDAO.findAll();
        for (Department obj: departments) {
            System.out.println(obj);
        }
        System.out.println("\n");

        System.out.println("===== TEST 3: DEPARTMENT INSERT ====");

        Department newDepartment = new Department(null,"Music");
        departmentDAO.insert(newDepartment);
        System.out.println("Inserted! New Department: " + newDepartment);


        System.out.println("\n");

        System.out.println("===== TEST 4: DEPARTMENT UPDATE ====");

        department = departmentDAO.findById(2);
        department.setName("Movies");
        departmentDAO.update(department);
        System.out.println("Updated Complete");


        System.out.println("\n");

        System.out.println("===== TEST 5: DEPARTMENT DELETE ====");

        System.out.println("Insert Id for delete test");
        int id = sc.nextInt();
        departmentDAO.deleteById(id);
        System.out.println("Deleted Completed");
        sc.close();

    }
}