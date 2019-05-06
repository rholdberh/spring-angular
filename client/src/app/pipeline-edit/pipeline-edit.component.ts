import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { ActivatedRoute, Router } from '@angular/router';
import { PipelineService } from '../shared/pipeline/pipeline.service';
import { NgForm } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { ConfigurationService } from '../shared/pipeline/configuraion.service';

export interface Dropdown {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-pipeline-edit',
  templateUrl: './pipeline-edit.component.html',
  styleUrls: ['./pipeline-edit.component.css']
})
export class PipelineEditComponent implements OnInit, OnDestroy {
  data: any = {};

  fileUrl: any;

  error;

  envlist: Dropdown[] = [];

  jdbclist: Dropdown[] = [];

  isSourceHive = false;

  isTargetHive = false;

  hivelist: Dropdown[] = [];

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private pipelineService: PipelineService,
              private configurationService: ConfigurationService,
              private sanitizer: DomSanitizer) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params.id;
      if (id) {
        this.pipelineService.get(id).subscribe((pipeline: any) => {
        if (pipeline) {
            this.data = pipeline;
            this.generateDownloadJsonUri(pipeline);
            this.isSourceHive = (pipeline.s_jdbc == 'org.apache.hive.jdbc.HiveDriver');
            this.isTargetHive = (pipeline.t_jdbc == 'org.apache.hive.jdbc.HiveDriver');
          } else {
            console.log(`pipeline with id '${id}' not found, returning to list`);
            this.gotoList();
          }
        });
      }
    });
    this.setDropdowns();

  }

  setDropdowns() {
    this.configurationService.getAll().subscribe((config: any) => {
        config.env.forEach(element => {
            this.envlist.push(
                {
                 value: element.value,
                 viewValue: element.value
            });

        });

        config.jdbcDrivers.forEach(element => {
            this.jdbclist.push(
                {
                 value: element.value,
                 viewValue: element.viewValue
            });

        });

        config.hiveJdbc.forEach(element => {
            this.hivelist.push(
                {
                 value: element.value,
                 viewValue: element.viewValue
            });

        });

    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/pipeline-list']);
  }

  save(form: NgForm) {
    this.pipelineService.save(form).subscribe(() => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    this.pipelineService.remove(href).subscribe(() => {
      this.gotoList();
    }, error => console.error(error));
  }

  generateDownloadJsonUri(data: any) {
        const theJSON = JSON.stringify(data);
        this.fileUrl = this.sanitizer.bypassSecurityTrustUrl('data:text/json;charset=UTF-8,' + encodeURIComponent(theJSON));

    }

}
