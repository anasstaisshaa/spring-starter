package edu.AnastasiiaTkachuk.spring.database.repository;

import edu.AnastasiiaTkachuk.spring.database.pool.ConnectionPool;

public class CompanyRepository {
    private final ConnectionPool connectionPool;

    public CompanyRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
