package com.ecomm.chkt.cart.repository.dao.impl;

import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.ecomm.chkt.cart.repository.CassandraSession;
import com.ecomm.chkt.cart.repository.dao.AddCartRepositoryManager;
import com.ecomm.chkt.cart.repository.domain.Order;
import com.ecomm.chkt.cart.repository.table.OrderTable;
import org.springframework.stereotype.Component;

@Component
public class AddCartRepositoryManagerImpl implements AddCartRepositoryManager {

    private final Mapper<Order> orderMapper;
    protected CassandraSession cassandraSession;

    public AddCartRepositoryManagerImpl() {
        MappingManager mappingManager = new MappingManager(cassandraSession.getSession());
        orderMapper = mappingManager.mapper(Order.class);
    }

    public int insertOrder(Order order) {

        Insert insert = getInsertQry();

        final PreparedStatement statement = cassandraSession.prepare(insert);
        Statement saveQuery = orderMapper.saveQuery(order, com.datastax.driver.mapping.Mapper.Option.ttl(6));
        final ResultSet rs = cassandraSession.execute(saveQuery);
        //final BoundStatement boundStatement = new BoundStatement(statement);
        return 1;

    }

    //TODO :: Not used
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


    public CassandraSession getCassandraSession() {
        return cassandraSession;
    }

    public void setCassandraSession(CassandraSession cassandraSession) {
        this.cassandraSession = cassandraSession;
    }
}

