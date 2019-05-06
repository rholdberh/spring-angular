package com.msd.iaas.tstconfig.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component("jdbcdriversdao")
public class JdbcDriversDao {


    private NamedParameterJdbcTemplate jdbc;


    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(jdbc);
    }

    public List<JdbcDrivers> getAll() {
        return jdbc.query("select * from DI_CONFIGURATION.JDBC_DRIVERS", (resultSet, i) -> {
            JdbcDrivers jdbc = new JdbcDrivers();
            jdbc.setId(resultSet.getInt("ID"));
            jdbc.setValue(resultSet.getString("VALUE"));
            jdbc.setViewValue(resultSet.getString("VIEW_VALUE"));
            return jdbc;
        });
    }


}
