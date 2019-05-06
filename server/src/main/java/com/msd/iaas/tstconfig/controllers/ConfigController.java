package com.msd.iaas.tstconfig.controllers;

import com.msd.iaas.tstconfig.dao.Pipeline;
import com.msd.iaas.tstconfig.services.ConfigurationService;
import com.msd.iaas.tstconfig.services.PipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/configuration")
public class ConfigController {

    private ConfigurationService configurationService;

    @Autowired
    public void setConfigurationService(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }


    @GetMapping(value = "/get")
    @ResponseBody
    public Map<String, Object> getConfiguration() {
        Map<String, Object> map = new HashMap<>();
        map.put("env", configurationService.getEnvironmentList());
        map.put("hiveJdbc", configurationService.getHiveConnection());
        map.put("jdbcDrivers", configurationService.getJdbcDrivers());
        return map;

    }


}
