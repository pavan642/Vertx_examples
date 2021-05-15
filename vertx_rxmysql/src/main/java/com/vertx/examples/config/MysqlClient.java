package com.vertx.examples.config;

import io.vertx.mysqlclient.MySQLConnectOptions;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.mysqlclient.MySQLPool;
import io.vertx.sqlclient.PoolOptions;

public class MysqlClient {

    public static MySQLPool getMysqlClient(Vertx vertx){
        MySQLConnectOptions connectOptions = new MySQLConnectOptions()
                .setPort(3306)
                .setHost("localhost")
                .setDatabase("reviews")
                .setUser("root")
                .setPassword("root");

        // Pool options
        PoolOptions poolOptions = new PoolOptions()
                .setMaxSize(5);

        // Create the client pool
        MySQLPool client = MySQLPool.pool(vertx, connectOptions, poolOptions);
        return client;

    }
}
