import { Component, Inject, OnInit, Optional } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Job } from '../_model/job';
import { Recruiter } from '../_model/recruiter';

@Component({
  selector: 'app-view-apply-dialog',
  templateUrl: './view-apply-dialog.component.html',
  styleUrls: ['./view-apply-dialog.component.css']
})
export class ViewApplyDialogComponent implements OnInit {


  job:Job = new Job(-1, "", "","", "","", "","", "", new Recruiter(-1,"","","",false));

  constructor(@Optional() @Inject(MAT_DIALOG_DATA) public data: Job[]) {
    console.log(data);
    this.job = data[0];
    console.log(this.job)

   }

  ngOnInit(): void {
  }

  

}
