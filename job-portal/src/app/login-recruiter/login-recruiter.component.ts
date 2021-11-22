import { animate, state, style, transition, trigger } from '@angular/animations';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core/public-api';
import { map } from 'rxjs';
import { Candidate } from '../_model/candidate';
import { Recruiter } from '../_model/recruiter';
import { AuthenticateService } from '../_service/authenticate.service';
/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}
@Component({
  selector: 'app-login-recruiter',
  templateUrl: './login-recruiter.component.html',
  styleUrls: ['./login-recruiter.component.css'],
 
})
export class LoginRecruiterComponent implements OnInit {

  constructor(private authenticateService:AuthenticateService) { }

  ngOnInit(): void {
  }

  animate:boolean=true

  @Output() currentRecruiterEmitter: EventEmitter<Recruiter> =   new EventEmitter();

  books = [{name:"Java", pages:102}, {name:"C#", pages:402} , {name:"let us c", pages:302}]

  currentRecruiter :Recruiter = new Recruiter(-1,"","","",false)

  loginErrorMsg: string = ""
  isLoading:boolean=false;

  onClickSubmit(value:any){

    this.isLoading = true;
    console.log("Login Recruiter")

    // console.log(value)
    // // this.value = value.passwd

    // this.authenticateService.authenticate(value.emailid, value.passwd)
    this.authenticateService.authenticateRecruiter("17", "a")

    .pipe(map(y=>y))
    .subscribe({
      
      next: 
      (x)=> {
      this.currentRecruiter = x
      console.log(x.email)
      console.log(this.currentRecruiter)
      this.currentRecruiterEmitter.emit(this.currentRecruiter)
      console.log("Emitting done")
    },

    error:
    error=> { 
              this.loginErrorMsg="Username / password is incorrect!" 
              this.isLoading=false;
            },

    complete:
      ()=>{
            console.log("Completed!")
            this.isLoading=false;
          }

  })
    
  }


  onSubmit(){

  }
}
