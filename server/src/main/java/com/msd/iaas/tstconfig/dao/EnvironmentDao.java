package com.msd.iaas.tstconfig.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component("environmentdao")
public class EnvironmentDao {


    private NamedParameterJdbcTemplate jdbc;


    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(jdbc);
    }

    public List<Environment> getAll() {
        return jdbc.query("select * from DI_CONFIGURATION.ENVIRONMENT", (resultSet, i) -> {
            Environment env = new Environment();
            env.setId(resultSet.getInt("ID"));
            env.setValue(resultSet.getString("VALUE"));
            return env;
        });
    }


}
