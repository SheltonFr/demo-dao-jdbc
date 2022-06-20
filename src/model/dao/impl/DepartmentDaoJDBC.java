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
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

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
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("UPDATE department "
                    + "set Name = ? WHERE Id = ?");
            
            st.setString(1, obj.getName());
            st.setInt(2, obj.getId());
            st.executeUpdate();
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());

        }finally{
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
            st.setInt(1, id);
            
            int rows = st.executeUpdate();
            if(rows <= 0){
                throw new DbException("Error");
            }
            
        }catch(SQLException e ){
            throw new DbException(e.getMessage());
        }
        DB.closeStatement(st);
      
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("SELECT * FROM department "
                    + "WHERE department.ID = ?");
            st.setInt(1, id);
            
            rs = st.executeQuery();
            if(rs.next()){
                Department dep = new Department(rs.getInt("Id"), rs.getString("Name"));
                return dep;
            }else {
                
                throw new DbException("Error finding the department");
            }
            
        }
        catch(SQLException e){
            
            throw new DbException(e.getMessage());

        }finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("SELECT * FROM department");
            rs = st.executeQuery();
            
            List<Department> list = new ArrayList<>();
            while(rs.next()){
                Department dep = new Department(rs.getInt("Id"), rs.getString("Name"));
                list.add(dep);
            }
            
            return list;
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());

        }finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        
    }
    
}
