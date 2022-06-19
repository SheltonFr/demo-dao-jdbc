/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

/**
 *
 * @author Admin
 */
public class Program {
    public static void main(String[] args) {
        
        
        SellerDao sellerDao = DaoFactory.createSellerDao();
        
        System.out.println("=== TESTE 1: seller findById ===");
        Seller seller = sellerDao.findById(1);
        
        System.out.println(seller);
    }
}
