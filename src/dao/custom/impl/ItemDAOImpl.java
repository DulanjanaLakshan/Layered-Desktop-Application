package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ItemDAO;
import entity.Customer;
import entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean add(Item dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO item (code,name, description, qty, price) VALUES (?,?,?,?,?)", dto.getCode(), dto.getName(), dto.getDescription(),dto.getQty(),dto.getPrice());
    }

    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM item WHERE code=?", code);
    }

    @Override
    public boolean update(Item dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE Customer SET name=?, description=?, qty=?,price=? WHERE code=?", dto.getName(), dto.getDescription(),dto.getQty(),dto.getPrice(), dto.getCode());
    }

    @Override
    public Item search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Item> allItem = new ArrayList();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Customer");
        while (rst.next()) {
            allItem.add(new Item(rst.getString("code"), rst.getString("name"), rst.getString("description"),Integer.parseInt(rst.getString("qty")),Double.parseDouble(rst.getString("price"))));
        }
        return allItem;
    }
    @Override
    public boolean ifCustomerExist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

}
