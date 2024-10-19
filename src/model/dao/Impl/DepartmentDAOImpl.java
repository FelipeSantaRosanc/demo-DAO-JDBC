package model.dao.Impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDAO;
import model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentDAOImpl implements DepartmentDAO {

    private Connection conn;

    public DepartmentDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {

        PreparedStatement st = null;

        try{
            st = conn.prepareStatement(
              "INSERT INTO department "
                  + "(Name) "
                  + "VALUES "
                  + "(?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1,obj.getName());

            int rowsAffected = st.executeUpdate();

            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            }
            else {
                throw new DbException("Unexpected Error! No rows affected!");
            }

        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void update(Department obj) {

        PreparedStatement st = null;

        try{
            st = conn.prepareStatement(
                    "UPDATE department "
                    + "SET Name = ? "
                    + "WHERE Id =  ?");

            st.setString(1,obj.getName());
            st.setInt(2, obj.getId());

            st.executeUpdate();

        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }


    }

    @Override
    public void deleteById(Integer id) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "DELETE FROM department WHERE Id = ?");
            st.setInt(1,id);
            st.executeUpdate();



        }

        catch (SQLException e){

            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement(
                    "SELECT department.*, department.Name as DepName "
                      + "FROM department "
                      + "WHERE department.Id = ?");

            st.setInt(1,id);
            rs = st.executeQuery();
            if(rs.next()){
                Department dep = instantiateDepartment(rs);
                return dep;
            }
            return null;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }

    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement(
                    "SELECT department.* , department.Name as DepName "
                        + "FROM department "
                        + "ORDER BY department.Name");

            rs = st.executeQuery();

            List<Department> depList = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()){
                Department dep = map.get(rs.getInt("Id"));

                if(dep == null){
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("Id"), dep);
                }

                depList.add(dep);
            }
            return depList;

        } catch (SQLException e){
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }


    }

    private Department instantiateDepartment (ResultSet rs) throws SQLException {
        Department department = new Department();
        department.setId(rs.getInt("Id"));
        department.setName(rs.getString("DepName"));
        return department;
    }
}
