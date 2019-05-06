package com.msd.iaas.tstconfig.services;

import com.msd.iaas.tstconfig.dao.Pipeline;
import com.msd.iaas.tstconfig.dao.PipelineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pipelineService")
public class PipelineService {

    private PipelineDao pipelineDao;

    @Autowired
    public void setPipelineDao(PipelineDao pipelineDao) {
        this.pipelineDao = pipelineDao;
    }

    public PipelineDao getPipelineDao() {
        return pipelineDao;
    }

    public List<Pipeline> getAll(){
        return pipelineDao.getAll();
    }

    public boolean create(Pipeline pipeline){
        return pipelineDao.createPipeline(pipeline);
    }

    public boolean update(Pipeline pipeline){
        return pipelineDao.updatePipeline(pipeline);
    }

    public Pipeline getById(int i) {
        return pipelineDao.getById(i);
    }


}
