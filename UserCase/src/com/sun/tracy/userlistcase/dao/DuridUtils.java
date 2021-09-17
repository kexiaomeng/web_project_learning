package com.sun.tracy.userlistcase.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DuridUtils {

    private static DataSource dataSource = null;
    static {
        Properties properties = new Properties();
        try {
            properties.load(DuridUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }


    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


}
