package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl {

    public List<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");

        List<CustomerDTO> list = new ArrayList<>();
        while(rst.next()){
            CustomerDTO customerDTO = new CustomerDTO();
            rst.getString("id");
            rst.getString("name");
            rst.getString("address");

            list.add(customerDTO);

        }
        return list;
    }
}
