
  import {HttpClient } from '@angular/common/http';
  import {Observable} from 'rxjs/Observable';
  import { HttpHeaders } from '@angular/common/http';
  import { Injectable } from '@angular/core';

  const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
  })
};

  @Injectable({
providedIn: 'root'
})
export class PipelineService {

  public API = '//54.40.117.248:8080';
  public PIPELINE_API = this.API + '/api/v1/pipelines';

constructor(private http: HttpClient) {

}

getAll(): Observable<any> {
    return this.http.get(this.PIPELINE_API + '/list');
  }

get(id: string): Observable<any> {
    return this.http.get(this.PIPELINE_API + '/get?id=' + id);
  }

save(pipeline: any): Observable<any> {
     console.log(pipeline);
     return this.http.post(this.PIPELINE_API + '/add', pipeline, httpOptions);
  }


remove(href: string) {
    return this.http.delete(href);
  }

}
