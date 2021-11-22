import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JobService {
  [x: string]: any;


  constructor(private http: HttpClient) { 

  }

  getJobAll(){
    return this.http.get("http://localhost:8123/getAllJobs")
  }

  
  applyForJob(jobId: number, candidateId: number){
    return this.http.post("http://localhost:8123/applyForJob?candidateId=" + candidateId + "&" + "jobId=" + jobId,{"id":"a"});
  }

}
