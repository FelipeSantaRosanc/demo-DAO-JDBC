package model.dao;

import db.DB;
import model.dao.Impl.DepartmentDAOImpl;
import model.dao.Impl.SellerDAOImpl;

public class DaoFactory {

    public static SellerDAO createSellerDAO(){
        return new SellerDAOImpl(DB.getConnection());
    }

    public static DepartmentDAO createDepartmentDAO(){
        return new DepartmentDAOImpl(DB.getConnection());
    }

}
