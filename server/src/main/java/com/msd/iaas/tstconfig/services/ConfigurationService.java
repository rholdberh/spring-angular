package com.msd.iaas.tstconfig.services;

import com.msd.iaas.tstconfig.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sonfigurationservice")
public class ConfigurationService {

    private HiveConnectionDao hiveConnectionDao;

    private JdbcDriversDao jdbcDriversDao;

    private EnvironmentDao environmentDao;


    @Autowired
    public void setHiveConnectionDao(HiveConnectionDao hiveConnectionDao) {
        this.hiveConnectionDao = hiveConnectionDao;
    }

    @Autowired
    public void setJdbcDriversDao(JdbcDriversDao jdbcDriversDao) {
        this.jdbcDriversDao = jdbcDriversDao;
    }

    @Autowired
    public void setEnvironmentDao(EnvironmentDao environmentDao) {
        this.environmentDao = environmentDao;
    }

    public List<JdbcDrivers> getJdbcDrivers () {
        return jdbcDriversDao.getAll();
    }

    public List<HiveConnections> getHiveConnection() {
        return hiveConnectionDao.getAll();
    }

    public List<Environment> getEnvironmentList(){
        return environmentDao.getAll();
    }


}
