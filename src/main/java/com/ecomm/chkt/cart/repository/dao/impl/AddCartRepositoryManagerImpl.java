package com.ecomm.chkt.cart.repository.dao.impl;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.ecomm.chkt.cart.repository.CassandraConnector;
import com.ecomm.chkt.cart.repository.dao.AddCartRepositoryManager;
import com.ecomm.chkt.cart.repository.domain.Order;
import com.ecomm.chkt.cart.repository.mapper.OrderRepoMapper;
import com.ecomm.chkt.cart.repository.table.OrderTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddCartRepositoryManagerImpl implements AddCartRepositoryManager {

    private final Mapper<Order> orderMapper;
    private Session cassandraSession;

    @Autowired
    private OrderRepoMapper orderRepoMapper;

    public AddCartRepositoryManagerImpl() {
        cassandraSession = CassandraConnector.getInstance().getSession();
        MappingManager mappingManager = new MappingManager(cassandraSession);
        orderMapper = mappingManager.mapper(Order.class);
    }

    public int insertOrder(Order order) {

        Insert insertQry = getInsertQry();
        final ResultSet rs = cassandraSession.execute(insertQry);
        return 1;
    }

    public List<Order> viewAllCart() {

        final Select slctQuery = getAllCartSlctQry();
        final ResultSet rs = cassandraSession.execute(slctQuery);
        final List<Row> listRow = rs.all();
        Order order = null;
        List<Order> orderList = new ArrayList<Order>();
        for (Row orderItemRow : listRow) {
            order = orderRepoMapper.mapOrder(orderItemRow);
            orderList.add(order);
        }
        return orderList;
    }

    private Insert getInsertQry() {
        final Insert insert = QueryBuilder.insertInto(OrderTable.ORDER)
                .values(
                        new String[]{
                                OrderTable.ORDER_ID,
                                OrderTable.ORDER_STATUS,
                                OrderTable.ORDER_ITEM_ID,
                                OrderTable.ORDER_ITEM_NAME
                        },
                        new Object[]{
                                QueryBuilder.bindMarker(),
                                QueryBuilder.bindMarker(),
                                QueryBuilder.bindMarker(),
                                QueryBuilder.bindMarker()
                        }
                );

        insert.using(com.datastax.driver.core.querybuilder.QueryBuilder.ttl(QueryBuilder.bindMarker("TTL")));
        return insert;
    }

    private Select getAllCartSlctQry() {
        final Select selectQuery = QueryBuilder.select().all().from("cart_keyspace", OrderTable.ORDER);
        return selectQuery;
    }
}

