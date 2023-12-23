package com.example.layeredarchitecture.bo.impl;

import com.example.layeredarchitecture.bo.ItemBO;
import com.example.layeredarchitecture.dao.CustomerDAO;
import com.example.layeredarchitecture.dao.ItemDAO;
import com.example.layeredarchitecture.dao.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.dao.impl.ItemDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.List;

public class ItemBOImpl implements ItemBO
{
    ItemDAO itemDAO = new ItemDAOImpl();

    @Override
    public List<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();

    }

    @Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {

        return itemDAO.save(dto);
    }


    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(dto);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(id);
    }

    @Override
    public boolean exits(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.exits(id);
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewId();
    }

    @Override
    public ItemDTO getDetail(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.getDetail(id);
    }
}
