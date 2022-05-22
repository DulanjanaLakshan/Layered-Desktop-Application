package dao.custom;

import dao.CrudDAO;
import entity.Item;

import java.sql.SQLException;

public interface ItemDAO extends CrudDAO<Item,String> {
    boolean ifCustomerExist(String id) throws SQLException, ClassNotFoundException;
    String generateNewID() throws SQLException, ClassNotFoundException;
}
