package com.ecomm.chkt.cart.repository.domain;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "cart_keyspace", name = "orders")
public class Order {

    @PartitionKey
    @Column(name="o_order_id")
    private int orderId;
    @Column(name="o_order_status")
    private String status;

    @ClusteringColumn
    @Column(name="oi_order_item_id")
    private int itemId;
    @Column(name="oi_order_item_name")
    private String itemName;

    public Order(int orderId, String status, int itemId, String itemName) {
        this.orderId = orderId;
        this.status = status;
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
