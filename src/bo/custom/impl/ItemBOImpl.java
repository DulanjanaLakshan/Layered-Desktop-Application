package bo.custom.impl;

import bo.custom.ItemBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> allItem = new ArrayList<>();
        ArrayList<Item> all = itemDAO.getAll();
        for (Item item : all) {
            allItem.add(new ItemDTO(item.getCode(), item.getName(), item.getDescription(),item.getQty(),item.getPrice()));
        }
        return allItem;
    }

    @Override
    public boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.add(new Item(dto.getCode(), dto.getName(), dto.getDescription(),dto.getQty(),dto.getPrice()));
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new Item(dto.getCode(), dto.getName(), dto.getDescription(),dto.getQty(),dto.getPrice()));
    }

    @Override
    public boolean ifCustomerExist(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.ifCustomerExist(code);
    }

    @Override
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(code);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewID();
    }
}
