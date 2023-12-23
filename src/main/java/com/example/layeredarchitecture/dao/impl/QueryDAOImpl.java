package com.example.layeredarchitecture.dao.impl;

import com.example.layeredarchitecture.dao.QueryDAO;
import com.example.layeredarchitecture.dao.SuperDAO;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryDAOImpl implements QueryDAO {
    public void customerOrderDatails(CustomerDTO customerDTO) {
        try {
            ResultSet resultSet = CrudUtil.crudUtil("SELECT c.id,c.name,c.address,o.oid,o.date,o2.itemCode,o2.qty,o2.unitPrice FROM customer c JOIN company.orders o ON c.id = o.customerID JOIN company.orderdetails o2 ON o.oid = o2.oid JOIN (SELECT customerID,MAX(o.oid) AS max_oid FROM customer c JOIN company.orders o ON c.id = o.customerID GROUP BY customerID) last_order ON o.customerID = last_order.customerID AND o.oid = last_order.max_oid;\n");
            while (resultSet.next()) {
                System.out.printf("%-10s %-20s %-20s %-10s %-20s %-10s %-10s %-10s%n",
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("oid"),
                        resultSet.getString("date"),
                        resultSet.getString("itemCode"),
                        resultSet.getString("qty"),
                        resultSet.getString("unitPrice"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
