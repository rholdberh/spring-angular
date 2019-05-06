import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatTableModule, MatSelectModule, MatCheckboxModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import {Component, OnInit} from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PipelineService } from './shared/pipeline/pipeline.service';
import { HttpClientModule } from '@angular/common/http';
import { PipelineListComponent } from './pipeline-list/pipeline-list.component';
import { PipelineEditComponent } from './pipeline-edit/pipeline-edit.component';


const appRoutes: Routes = [
  { path: '', redirectTo: '/pipeline-list', pathMatch: 'full' },
  {
    path: 'pipeline-list',
    component: PipelineListComponent
  },
  {
    path: 'pipeline-add',
    component: PipelineEditComponent
  },
  {
    path: 'pipeline-edit/:id',
    component: PipelineEditComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    PipelineListComponent,
    PipelineEditComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    MatTableModule,
    MatSelectModule,
    MatCheckboxModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [PipelineService],
  bootstrap: [AppComponent]
})
export class AppModule { }
