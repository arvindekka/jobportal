import { animate, state, style, transition, trigger } from '@angular/animations';
import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ViewApplyDialogComponent } from '../view-apply-dialog/view-apply-dialog.component';
import { Candidate } from '../_model/candidate';
import { CandidateProfile } from '../_model/candidateProfile';
import { Job } from '../_model/job';
import { Recruiter } from '../_model/recruiter';
import { CandidateService } from '../_service/candidate.service';
import { JobService } from '../_service/job.service';

@Component({
  selector: 'app-home-candidate',
  templateUrl: './home-candidate.component.html',
  styleUrls: ['./home-candidate.component.css'],
  animations: [
    trigger('flyInOut', [
      state('in', style({ transform: 'translateX(0)' })),
      transition('void => *', [
        style({ transform: 'translateX(100%)' }),
        animate('100ms ease-in'),
      ]),
      transition('* => void', [
        animate( 0, style({ transform: 'translateX(-100%)' }))
      ])
    ])
  ]
})
export class HomeCandidateComponent implements OnInit {

  @Input() currentUser: Candidate = new Candidate("",-1,"","","",false)
  currentProfile:CandidateProfile  = new CandidateProfile(-1,"","",-1,-1,"");

  jobs: Job[] = []
  constructor(private jobService :JobService, private candidateService : CandidateService, public dialog: MatDialog) { }

  showJobs:boolean = false;

  selectedMenu : string="Profile"
  selectedMenuBackgroundColor: String = '#f1f1f1'

  onSelectMenu(menu: string){
    this.selectedMenu=menu;

    if(menu=="Jobs"){
      this.getJobs()
    }

    if(menu=="Profile"){
      this.getCandidateProfile()

    }
  }

  ngOnInit(): void {
  }

  getJobs(){
    this.jobService.getJobAll().subscribe((x:any)=>
      {
        console.log(x);
        this.jobs = x;
        console.log(this.jobs)
      })

      this.showJobs = true
  }
  getCandidateProfile(){
    console.log("Get Candidate Profile!")
    console.log(this.currentUser)
    this.showJobs = false

    this.candidateService.getProfile(this.currentUser).pipe(x=>x).subscribe( (x)=>{
      console.log(x)
      console.log(x)
      console.log(this.currentProfile);
      this.currentProfile=x;
    }
      )

    this.candidateService.getResume()
    this.candidateService.getSkill()



  }

  apply(jobId: number, candidateId: number){
      console.log("Candidate Id " + candidateId + " applied for job " + jobId);
      this.jobService.applyForJob(jobId, candidateId).subscribe(x=>console.log(x))
  }

  openDialog(jobId:number) {

    let job = this.jobs.filter(job=>job.id==jobId)
    const dialogRef = this.dialog.open(ViewApplyDialogComponent,
      
      {
        // width: '250px',
        backdropClass: 'custom-dialog-backdrop-class',
        panelClass: 'custom-dialog-panel-class',
        data: job
      }

      );

    dialogRef.afterClosed().subscribe(result => {
      console.log("arvind")
      console.log(`Dialog result: ${result}`);
    });
  }

}
