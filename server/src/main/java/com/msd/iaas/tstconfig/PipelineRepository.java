package com.msd.iaas.tstconfig;

import com.msd.iaas.tstconfig.dao.Pipeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface PipelineRepository extends JpaRepository<Pipeline, Long> {
}
