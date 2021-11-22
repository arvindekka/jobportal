import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Candidate } from '../_model/candidate';
import { CandidateProfile } from '../_model/candidateProfile';

@Injectable({
  providedIn: 'root'
})
export class CandidateService {

  constructor(private http: HttpClient) { 

  }

  getProfile(candidate: Candidate){
    console.log("Get Candidate Profile")
    console.log(candidate.id)
    this.http.get<CandidateProfile>(`http://127.0.0.1:8123/candidateProfile/${candidate.id}`).subscribe(x=>console.log(x))
    return this.http.get<CandidateProfile>(`http://127.0.0.1:8123/candidateProfile/${candidate.id}`);

  }

  getResume(){
    console.log("Get Candidate Resume")
  }

  getSkill(){
    console.log("Get Candidate Skills")
  }

  

}
