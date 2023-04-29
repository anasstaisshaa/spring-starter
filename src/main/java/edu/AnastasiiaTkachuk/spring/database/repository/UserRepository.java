package edu.AnastasiiaTkachuk.spring.database.repository;

import edu.AnastasiiaTkachuk.spring.database.pool.ConnectionPool;

public class UserRepository {
    private final ConnectionPool connectionPool;

    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
