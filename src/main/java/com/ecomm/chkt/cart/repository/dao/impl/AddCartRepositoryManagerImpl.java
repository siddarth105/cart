package com.ecomm.chkt.cart.repository.dao.impl;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.Clause;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.ecomm.chkt.cart.repository.CassandraConnector;
import com.ecomm.chkt.cart.repository.dao.AddCartRepositoryManager;
import com.ecomm.chkt.cart.repository.domain.Order;
import com.ecomm.chkt.cart.repository.domain.OrderInt;
import com.ecomm.chkt.cart.repository.mapper.OrderRepoMapper;
import com.ecomm.chkt.cart.repository.table.OrderTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddCartRepositoryManagerImpl implements AddCartRepositoryManager {

    private Session cassandraSession;

    @Autowired
    private OrderRepoMapper orderRepoMapper;

    public AddCartRepositoryManagerImpl() {
        cassandraSession = CassandraConnector.getInstance().getSession();
    }

    public int insertOrder(List<OrderInt> orderLst) {
        for (OrderInt order : orderLst) {
            Insert insertQry = getInsertQry(order);
            final ResultSet rs = cassandraSession.execute(insertQry);
        }
        return 1;
    }

    public List<OrderInt> viewAllCart(Integer orderId) {

        final Select slctQuery = getAllCartSlctQry(orderId);
        final ResultSet rs = cassandraSession.execute(slctQuery);
        final List<Row> listRow = rs.all();
        Order order = null;
        List<OrderInt> orderList = new ArrayList<OrderInt>();
        for (Row orderItemRow : listRow) {
            order = orderRepoMapper.mapOrder(orderItemRow);
            orderList.add(order);
        }
        return orderList;
    }

    private Insert getInsertQry(OrderInt order) {
        final Insert insert = QueryBuilder.insertInto("cart_keyspace", OrderTable.ORDER)
                .values(
                        new String[]{
                                OrderTable.ORDER_ID,
                                OrderTable.ORDER_STATUS,
                                OrderTable.ORDER_ITEM_ID,
                                OrderTable.ORDER_ITEM_NAME
                        },
                        new Object[]{
                                order.getOrderId(),
                                order.getStatus(),
                                order.getItemId(),
                                order.getItemName()
                        }
                );
        return insert;
    }

    private Select getAllCartSlctQry(Integer orderId) {
        final Select selectQuery = QueryBuilder.select().all().from("cart_keyspace", OrderTable.ORDER);
        Select.Where selectWhere = selectQuery.where();
        Clause clause = QueryBuilder.eq("o_order_id", orderId);
        selectWhere.and(clause);
        return selectQuery;
    }
}

