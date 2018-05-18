package com.ecomm.chkt.cart.repository;

import com.datastax.driver.core.*;
import com.datastax.driver.core.exceptions.DriverException;
import org.springframework.stereotype.Component;

@Component
public class CassandraSession {

    private final Session session;

    public CassandraSession(Session cassandraSession) {
        this.session = cassandraSession;
    }


    public PreparedStatement prepare(RegularStatement statement) {
        return session.prepare(statement);
    }

    public ResultSet execute(Statement statement) {
        try {
            return session.execute(statement);
        } catch (DriverException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ResultSetFuture executeAsync(Statement statement) {
        try {
            return session.executeAsync(statement);
        } catch (DriverException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Session getSession() {
        return session;
    }
}
