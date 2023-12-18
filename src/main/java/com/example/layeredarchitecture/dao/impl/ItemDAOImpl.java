package com.example.layeredarchitecture.dao.impl;

import com.example.layeredarchitecture.dao.ItemDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.util.CrudUtil;
import com.example.layeredarchitecture.view.tdm.ItemTM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public List<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.crudUtil("SELECT * FROM Item");

        List<ItemDTO> list = new ArrayList<>();
        while (rst.next()){
            ItemDTO itemDTO = new ItemDTO(
            rst.getString("code"),
            rst.getString("description"),
            rst.getBigDecimal("qtyOnHand"),
            rst.getInt("unitPrice"));

            list.add(itemDTO);
        }
        return list;
    }
@Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {
    return CrudUtil.crudUtil("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
    }
    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getCode());
    }
    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("DELETE FROM Item WHERE code=?");
    }
    @Override
    public boolean exits(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtil.crudUtil("SELECT code FROM Item WHERE code=?");
        return rst.next();

    }
    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.crudUtil("SELECT code FROM Item ORDER BY code DESC LIMIT 1");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }

    }
    @Override
    public ItemDTO getDetail(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.crudUtil("SELECT * FROM Item WHERE code=?",code);
        if(rst.next()) return new ItemDTO(code, rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
        else return null;
    }
}
