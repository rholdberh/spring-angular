
  import {HttpClient } from '@angular/common/http';
  import {Observable} from 'rxjs/Observable';
  import { Injectable } from '@angular/core';


  @Injectable({
providedIn: 'root'
})
export class ConfigurationService {

  public API = '//54.40.117.248:8080';
  public PIPELINE_API = this.API + '/api/v1/configuration';

constructor(private http: HttpClient) {

}

getAll(): Observable<any> {
    return this.http.get(this.PIPELINE_API + '/get');
  }


}
