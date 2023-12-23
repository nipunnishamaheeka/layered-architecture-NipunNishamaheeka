package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;

public interface QueryDAO extends SuperDAO{
    void customerOrderDatails(CustomerDTO dto) throws SQLException, ClassNotFoundException;
}
