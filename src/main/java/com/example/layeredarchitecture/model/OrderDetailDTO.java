package com.example.layeredarchitecture.model;

import java.io.Serializable;
import java.math.BigDecimal;



public class OrderDetailDTO implements Serializable {
    private String orderId;
    private String itemCode;
    private int qty;
    private BigDecimal unitPrice;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String orderId,String itemCode, int qty, BigDecimal unitPrice) {
        this.orderId=orderId;
        this.itemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "orderId='" + orderId + '\'' +
                "itemCode='" + itemCode + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
