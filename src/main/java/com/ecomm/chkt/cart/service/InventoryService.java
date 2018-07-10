package com.ecomm.chkt.cart.service;

import com.ecomm.chkt.cart.model.ItemDTO;

import java.util.List;

public interface InventoryService {
    boolean checkInventory(List<ItemDTO> itemLst);
}
