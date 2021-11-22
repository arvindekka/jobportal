import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Candidate } from '../_model/candidate';
import { Recruiter } from '../_model/recruiter';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {

  constructor(private http: HttpClient) { 

  }

  getCandidates(){
    return this.http.get("http://127.0.0.1:8123/candidates")
  }

  authenticate(loginId:string, password: string){
    return this.http.post<Candidate>("http://127.0.0.1:8123/authenticateCandidate", {
      "userId":loginId,
      "password":password
  })

  }

  
  authenticateRecruiter(loginId:string, password: string){
    return this.http.post<Recruiter>("http://127.0.0.1:8123/authenticateRecruiter", {
      "userId":loginId,
      "password":password
  })

  }


  logout(id: number) {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');

    return this.http.get<Candidate>("http://127.0.0.1:8123/logoutCandidate?id=" + id)
}

logoutRecruiter(id: number) {
  // remove user from local storage to log user out
  localStorage.removeItem('currentRecruiter');

  return this.http.get<Candidate>("http://127.0.0.1:8123/logoutRecruiter?id=" + id)
}

}
