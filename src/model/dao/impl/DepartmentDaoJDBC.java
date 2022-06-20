/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao.impl;

import db.DB;
import db.DbException;
import java.util.List;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author Shelton Francisco
 */
public class DepartmentDaoJDBC implements DepartmentDao{

    Connection conn = DB.getConnection();
    
    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }
    
    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("INSERT INTO department (name) "
                    + "VALUES(?)");
            
            st.setString(1, obj.getName());
            int rows = st.executeUpdate();
            
            if(rows > 0)
                System.out.println("Done! Inserted department: " + obj.getName());
            else
                throw new DbException("Error occured inseritng the department");
        }
        catch(SQLException e){
            throw new DbException("Erro: " + e.getMessage());
        }finally{
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Department obj) {
    }

    @Override
    public void deleteById(Integer id) {
    }

    @Override
    public Department findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Department> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
