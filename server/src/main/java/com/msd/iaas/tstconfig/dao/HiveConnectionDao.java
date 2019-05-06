package com.msd.iaas.tstconfig.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component("hiveconnectiondao")
public class HiveConnectionDao {


    private NamedParameterJdbcTemplate jdbc;


    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(jdbc);
    }

    public List<HiveConnections> getAll() {
        return jdbc.query("select * from DI_CONFIGURATION.HIVE_CONNECTIONS", (resultSet, i) -> {
            HiveConnections hiveConnections = new HiveConnections();
            hiveConnections.setId(resultSet.getInt("ID"));
            hiveConnections.setValue(resultSet.getString("VALUE"));
            hiveConnections.setViewValue(resultSet.getString("VIEW_VALUE"));
            return hiveConnections;
        });
    }


}
