package com.msd.iaas.tstconfig.controllers;

import com.msd.iaas.tstconfig.dao.Pipeline;
import com.msd.iaas.tstconfig.services.PipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/pipelines")
public class PipelineController {

    private PipelineService pipelinceService;

    @Autowired
    public void setPipelinceService(PipelineService pipelinceService) {
        this.pipelinceService = pipelinceService;
    }


    @GetMapping("/list")
    public Collection<Pipeline> pipelines() {
        return pipelinceService.getAll();
    }

    @GetMapping(value = "/get")
    @ResponseBody
    public Pipeline getPipelineById(@RequestParam("id") int id) {
        return pipelinceService.getById(id);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createUpdatePipeline(@RequestBody Pipeline pipeline) {
        System.out.println(pipeline);
        if (pipelinceService.getById(pipeline.getId()) != null) {
            pipelinceService.update(pipeline);
        } else {
            pipelinceService.create(pipeline);
        }
    }


}
