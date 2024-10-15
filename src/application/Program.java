package application;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Seller;



public class Program {
    public static void main(String[] args) {

        SellerDAO sellerDao = DaoFactory.createSellerDAO();

        System.out.println("===== TEST 1: SELLER BY Id ====");
        Seller seller = sellerDao.findById(7);

        System.out.println(seller);
    }
}