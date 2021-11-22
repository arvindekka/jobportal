import { Component, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Candidate } from './_model/candidate';
import { Recruiter } from './_model/recruiter';
import { AuthenticateService } from './_service/authenticate.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'job-portal';

  appLoggedInStatus:number=0

  currentUser :Candidate = new Candidate("",1,"","","",false);
  currentRecruiter :Recruiter = new Recruiter(-1,"","","",false);
  isCandidateLoggedIn :boolean = false;


  loginStatus(status:number){
    this.appLoggedInStatus=status 
  }
  constructor(private authenicationService:AuthenticateService, private router : Router) { }

  
  logoutCandidate(){
    console.log("Candidate logged out")
    this.authenicationService.logout(this.currentUser.id).subscribe(x=>console.log(x))
    this.isCandidateLoggedIn=false
    this.currentUser = new Candidate("",1,"","","",false);
  }
  logoutRecruiter(){
    console.log("Recruiter logged out")
    this.authenicationService.logoutRecruiter(this.currentRecruiter.id).subscribe(x=>console.log(x))
    this.currentRecruiter = new Candidate("",1,"","","",false);
  }

  getCurrentCandidateInAppComp(data:Candidate){
    console.log("In App Component")
    console.log(data)
    this.currentUser = data
    // this.router.navigate(["/homeCandidate"])
  }

  
  getCurrentRecruiterInAppComp(data:Recruiter){
    console.log("In App Component")
    console.log(data)
    this.currentRecruiter = data
    // this.router.navigate(["/homeCandidate"])
  }

  checkIfCandidateLoggedInInAppComp(data:boolean){
    this.isCandidateLoggedIn = data;
  }

}
