package application;

import model.dao.DaoFactory;

import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDAO sellerDao = DaoFactory.createSellerDAO();

        System.out.println("===== TEST 1: SELLER BY Id ====");
        Seller seller = sellerDao.findById(7);

        System.out.println(seller);

        System.out.println("\n");

        System.out.println("===== TEST 2: SELLER BY Department ====");
        Department department = new Department(4, null);
        List<Seller> sellers = sellerDao.findByDepartment(department);
        for (Seller obj : sellers) {
             System.out.println(obj);
        }
        System.out.println("\n");

        System.out.println("===== TEST 3: SELLER findALL ====");
         sellers = sellerDao.findAll();
        for (Seller obj : sellers) {
            System.out.println(obj);
        }
        System.out.println("\n");

        System.out.println("===== TEST 4: SELLER INSERT ====");

        Seller newSeller = new Seller(null, "Greg", "Greg@gmail.com", new Date(), 4000.00,department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n");

        System.out.println("===== TEST 5: SELLER UPDATE ====");

        seller = sellerDao.findById(15);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Updated Completed ");


        System.out.println("===== TEST 5: SELLER DELETE ====");

        System.out.println("Insert Id for delete test");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Deleted Completed");
        sc.close();



    }
}