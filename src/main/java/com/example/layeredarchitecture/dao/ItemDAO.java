package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface ItemDAO {

    public List<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;

    boolean saveItems(ItemDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateItems(ItemDTO dto) throws SQLException, ClassNotFoundException ;
    boolean deleteItems(String code) throws SQLException, ClassNotFoundException;
    boolean exitsItems(String code) throws SQLException, ClassNotFoundException;
    String generateNewId() throws SQLException, ClassNotFoundException ;
}
