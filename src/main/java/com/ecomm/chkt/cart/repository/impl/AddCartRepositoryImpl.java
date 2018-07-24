package com.ecomm.chkt.cart.repository.impl;

import com.ecomm.chkt.cart.model.OrderDTO;
import com.ecomm.chkt.cart.repository.AddCartRepository;
import com.ecomm.chkt.cart.repository.dao.AddCartRepositoryManager;
import com.ecomm.chkt.cart.repository.domain.OrderInt;
import com.ecomm.chkt.cart.repository.domain.OrderV2;
import com.ecomm.chkt.cart.repository.mapper.DtoToOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddCartRepositoryImpl implements AddCartRepository {

    @Autowired
    private AddCartRepositoryManager addCartRepositoryManager;

    @Autowired
    private DtoToOrderMapper dtoToOrderMapper;

    @Autowired
    private CassandraOperations cassandraOperations;

    static final String GET_ORDER_QRY = "select * from orders where o_order_id = ?";

    public int insert(OrderDTO orderDTO, boolean isV2) {

        List<OrderInt> orderLst = dtoToOrderMapper.map(orderDTO, isV2);
        if (!isV2) {
            return addCartRepositoryManager.insertOrder(orderLst);
        } else {
            cassandraOperations.batchOps().insert(orderLst).execute();
            return 1;
        }
    }

    public List<? extends OrderInt> viewAllCart(Integer orderId, boolean isV2) {
        if (!isV2) {
            return addCartRepositoryManager.viewAllCart(orderId);
        } else {
            String qry = GET_ORDER_QRY.replace("?", orderId.toString());
            return cassandraOperations.select(qry, OrderV2.class);
        }
    }
}
