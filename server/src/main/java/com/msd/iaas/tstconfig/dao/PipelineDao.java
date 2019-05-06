package com.msd.iaas.tstconfig.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

import java.util.List;

@Component("pipelinedao")
public class PipelineDao {


    private NamedParameterJdbcTemplate jdbc;


    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(jdbc);
    }

    public List<Pipeline> getAll() {
        return jdbc.query("select * from DI_CONFIGURATION.PIPELINES", (resultSet, i) -> {
            Pipeline pipeline = new Pipeline();
            pipeline.setId(resultSet.getInt("ID"));
            pipeline.setSystem(resultSet.getString("SYSTEM"));
            pipeline.setLocation(resultSet.getString("LOCATION"));
            pipeline.setS_jdbc(resultSet.getString("S_JDBC"));
            pipeline.setT_jdbc(resultSet.getString("T_JDBC"));
            pipeline.setJson(resultSet.getString("JSON"));
            pipeline.setS_schema(resultSet.getString("S_SCHEMA"));
            pipeline.setT_schema(resultSet.getString("T_SCHEMA"));
            pipeline.setT_url(resultSet.getString("T_URL"));
            pipeline.setS_url(resultSet.getString("S_URL"));
            pipeline.setS_user(resultSet.getString("S_USER"));
            pipeline.setT_user(resultSet.getString("T_USER"));
            pipeline.setEnv(resultSet.getString("ENV"));
            return pipeline;
        });
    }


    public boolean createPipeline(Pipeline pipeline) {
        BeanPropertySqlParameterSource bean = new BeanPropertySqlParameterSource(pipeline);
        return jdbc.update("insert into DI_CONFIGURATION.PIPELINES(ID,SYSTEM,LOCATION,S_URL,T_URL,T_USER,S_SCHEMA,T_SCHEMA,S_JDBC,T_JDBC,JSON,S_USER,ENV) " +
                "values(id_increment.NEXTVAL,:system,:location,:s_url,:t_url,:t_user,:s_schema,:t_schema,:s_jdbc,:t_jdbc,:json,:s_user,:env)", bean) == 1;
    }

    public boolean updatePipeline(Pipeline pipeline) {
        BeanPropertySqlParameterSource bean = new BeanPropertySqlParameterSource(pipeline);
        return jdbc.update("update DI_CONFIGURATION.PIPELINES set " +
                "system=:system,location=:location,s_url=:s_url,t_url=:t_url,t_user=:t_user,s_schema=:s_schema,t_schema=:t_schema,s_jdbc=:s_jdbc,t_jdbc=:t_jdbc," +
                "json=:json,s_user=:s_user,env=:env WHERE id=:id", bean) == 1;
    }

    public Pipeline getById(int id) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource("id", id);
            return jdbc.queryForObject("select * from DI_CONFIGURATION.PIPELINES where id=:id", params,
                    new BeanPropertyRowMapper<>(Pipeline.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

}
