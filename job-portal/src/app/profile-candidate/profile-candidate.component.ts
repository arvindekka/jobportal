import { Component, Input, OnInit } from '@angular/core';
import { Candidate } from '../_model/candidate';
import { CandidateProfile } from '../_model/candidateProfile';

@Component({
  selector: 'app-profile-candidate',
  templateUrl: './profile-candidate.component.html',
  styleUrls: ['./profile-candidate.component.css']
})
export class ProfileCandidateComponent implements OnInit {

  fruits:string[]=[]
  removable:boolean=true

  @Input() currentProfile :CandidateProfile = new CandidateProfile(-1,"","",-1,-1,"");
  @Input() currentUser: Candidate = new Candidate("",-1,"","","",false)

  constructor() {
    console.log(this.currentUser)
   }

  ngOnInit(): void {
  }

  onClickSubmit(){
    console.log("Saving profile!")
  }

  add(fruit:any){

    this.fruits.push(fruit)

  }
  remove(fruit:any){

    this.fruits.push(fruit)

  }
}
