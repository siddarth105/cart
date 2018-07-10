package com.ecomm.chkt.cart.service;

import com.ecomm.chkt.cart.model.ItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServImpl implements InventoryService {

    public boolean checkInventory(List<ItemDTO> itemLst) {
        return true;
    }

}
