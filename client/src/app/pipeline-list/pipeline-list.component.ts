import {Component, OnInit, NgModule} from '@angular/core';
import {PipelineService} from '../shared/pipeline/pipeline.service';

@Component({
selector: 'app-pipeline-list',
templateUrl: './pipeline-list.component.html',
styleUrls: ['./pipeline-list.component.css']
})

export class PipelineListComponent implements OnInit {
dataSource: Array<any>;
displayedColumns: string[] = ['id', 'system', 'location', 'type', 'env', 'buttons'];

constructor(private pipelineService: PipelineService) { }


ngOnInit() {
    this.pipelineService.getAll().subscribe(data => {
      this.dataSource = data;
    });

}

public getJson(id: string, system: string, location: string) {
    this.pipelineService.get(id).subscribe(data => {
        const theJSON = JSON.stringify(data);
        const link = document.createElement('a');
        link.setAttribute('href', 'data:text/json;charset=UTF-8,' + encodeURIComponent(theJSON));
        link.setAttribute('download', system + '_' + location + '.json');
        link.style.visibility = 'hidden';
        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);

        });

    }

}
