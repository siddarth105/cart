package com.ecomm.chkt.cart.repository;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CassandraConnector {

    private Cluster cluster;

    private Session session;

    private static final CassandraConnector cassandraConnector = new CassandraConnector();

    private CassandraConnector() {

    }

    public static CassandraConnector getInstance() {
        return cassandraConnector;
    }

    public void connect(String node, Integer port) {
        Cluster.Builder b = Cluster.builder().addContactPoint(node);
        if (port != null) {
            b.withPort(port);
        }
        cluster = b.build();

        session = cluster.connect();
    }

    public Session getSession() {
        return cassandraConnector.session;
    }

    public void close() {
        session.close();
        cluster.close();
    }
}
