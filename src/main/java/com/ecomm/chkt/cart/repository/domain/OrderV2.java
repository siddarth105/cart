package com.ecomm.chkt.cart.repository.domain;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("orders")
public class OrderV2 implements OrderInt {

    @PrimaryKey("o_order_id")
    private int orderId;

    @Column("o_order_status")
    private String status;

    @Column("oi_order_item_id")
    private int itemId;

    @Column("oi_order_item_name")
    private String itemName;

    public OrderV2(int orderId, String status, int itemId, String itemName) {
        this.orderId = orderId;
        this.status = status;
        this.itemId = itemId;
        this.itemName = itemName;
    }

    @Override
    public int getOrderId() {
        return orderId;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public int getItemId() {
        return itemId;
    }

    @Override
    public String getItemName() {
        return itemName;
    }
}
