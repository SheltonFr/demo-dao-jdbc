
package application;

import java.util.Date;
import java.util.List;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

/**
 *
 * @author Admin
 */
public class Program {
    public static void main(String[] args) {
        
        /*
        SellerDao sellerDao = DaoFactory.createSellerDao();
        
        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(1);
        System.out.println(seller);
        
        System.out.println("\n=== TEST 2: seller findByDepartemnt ===");
        Department department = new Department(1, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj: list){
            System.out.println(obj);
        }
        
        System.out.println("\n=== TEST 3: seller findAll ===");
        list = sellerDao.findAll();
        for(Seller obj: list){
            System.out.println(obj);
        }
        
        System.out.println("\n=== TEST 4: seller Insert ===");
        Seller newSeller = new Seller(null,"Kenneth","ken@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New Id = " + newSeller.getId());
        
        System.out.println("\n=== TEST 5: seller Update ===");
        seller = sellerDao.findById(4);
        seller.setName("Ana Maria");
        sellerDao.update(seller);
        System.out.println("Update completed!");
        
        System.out.println("\n=== TEST 6: seller Update ===");
        sellerDao.deleteById(8);
        sellerDao.deleteById(7);
        sellerDao.deleteById(6);
        System.out.println("Deleted!"); */
        
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        
        System.out.println("\n=== TEST 1: Insert Departemt ===");
        Department newDepartemnt = new Department(null, "MEcanica");
        //departmentDao.insert(newDepartemnt);
        
        System.out.println("\n=== TEST 2: FindById Departemt ===");
        newDepartemnt = departmentDao.findById(1);
        System.out.println(newDepartemnt);
     
         /*System.out.println("\n=== TEST 3: Find All departments ===");
         List<Department> list = departmentDao.findAll();
         for(Department dep : list){
             System.out.println(dep);
         }*/
         
         System.out.println("\n=== TESTE 4: Updatint department ===");
         Department d = new Department(5,"Engenharia");
         departmentDao.update(d);
    }
}
