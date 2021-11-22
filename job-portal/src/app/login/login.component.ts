import { Component, EventEmitter, OnInit, Output, ViewChild } from '@angular/core';
import {
  trigger,
  state,
  style,
  animate,
  transition,
  query,
  group,
  animateChild,
  // ...
} from '@angular/animations';
import { Candidate } from '../_model/candidate';
import { AuthenticateService } from '../_service/authenticate.service';
import { Recruiter } from '../_model/recruiter';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  animations: [
    trigger('flyInOut', [
      state('in', style({ transform: 'translateX(0)' })),
      transition('void => *', [
        style({ transform: 'translateX(100%)' }),
        animate('300ms ease-in'),
      ]),
      transition('* => void', [
        animate( 0, style({ transform: 'translateX(-100%)' }))
      ])
    ])
  ]
})
export class LoginComponent implements OnInit {
  isOpen = true;
  @Output() currentCandidateEmitter: EventEmitter<Candidate> =   new EventEmitter();
  @Output() currentRecruiterEmitter: EventEmitter<Recruiter> =   new EventEmitter();
  @Output() isCandidateLoggedIdEmitter: EventEmitter<boolean> =   new EventEmitter();

  toggleLogin: boolean = true;
  isCandidateLoggedIn: boolean = false;

  getCurrentCandidate(data:Candidate){
    console.log("In parent")
    console.log(data)
    this.isCandidateLoggedIn = true;

    //Sending the candidate details to app component
    this.currentCandidateEmitter.emit(data);
    this.isCandidateLoggedIdEmitter.emit(this.isCandidateLoggedIn)

  }

  getCurrentRecruiter(data:Recruiter){
    console.log("In parent")
    console.log(data)
    this.isCandidateLoggedIn = false;
    this.currentRecruiterEmitter.emit(data);
  }

  checkIfCandidateLoggedIn(){
    this.isCandidateLoggedIdEmitter.emit(this.isCandidateLoggedIn)
  }

  toggle() {
    this.isOpen = !this.isOpen;
    this.animate = !this.animate;
  }
  constructor(private authenicationService:AuthenticateService) { }

  ngOnInit(): void {


  }
  showCandidateLogin(){
    this.toggleLogin=true
    this.toggle()
  }
  showRecruiterLogin(){
    this.toggleLogin=false
    this.toggle()
  }

  animate:boolean=false;

}
