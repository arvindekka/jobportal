import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import {MatFormField, MatFormFieldModule, MatLabel} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SuggestionComponent } from './suggestion/suggestion.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginCandidateComponent } from './login-candidate/login-candidate.component';
import { LoginRecruiterComponent } from './login-recruiter/login-recruiter.component';
import { HomeCandidateComponent } from './home-candidate/home-candidate.component';
import { ViewApplyComponent } from './view-apply/view-apply.component';
import { ViewApplyDialogComponent } from './view-apply-dialog/view-apply-dialog.component';
import {MatDialogModule} from '@angular/material/dialog';
import { CandidateProfileComponent } from './candidate-profile/candidate-profile.component';
import { ProfileCandidateComponent } from './profile-candidate/profile-candidate.component';
import {MatChipsModule} from '@angular/material/chips';
import {MatIconModule} from '@angular/material/icon';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import { HomeRecruiterComponent } from './home-recruiter/home-recruiter.component';
import {MatTabsModule} from '@angular/material/tabs';
import { ProfileComponent } from './home-recruiter/profile/profile.component';
import { CandidatesComponent } from './home-recruiter/candidates/candidates.component';
import { PostJobComponent } from './home-recruiter/post-job/post-job.component';
import { JobsComponent } from './home-recruiter/jobs/jobs.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SuggestionComponent,
    LoginCandidateComponent,
    LoginRecruiterComponent,
    HomeCandidateComponent,
    ViewApplyComponent,
    ViewApplyDialogComponent,
    CandidateProfileComponent,
    ProfileCandidateComponent,
    HomeRecruiterComponent,
    ProfileComponent,
    CandidatesComponent,
    PostJobComponent,
    JobsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    FormsModule,
    HttpClientModule,
    MatDialogModule,
    MatChipsModule,
    MatIconModule,
    MatButtonModule,
    MatInputModule,
    MatProgressBarModule,
    MatTabsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
