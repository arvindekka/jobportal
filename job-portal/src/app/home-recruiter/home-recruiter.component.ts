import { Component, Input, OnInit } from '@angular/core';
import { ThemePalette } from '@angular/material/core';
import { Recruiter } from '../_model/recruiter';


@Component({
  selector: 'app-home-recruiter',
  templateUrl: './home-recruiter.component.html',
  styleUrls: ['./home-recruiter.component.css']
})
export class HomeRecruiterComponent implements OnInit {

  @Input() currentRecruiterInHomeRecruiterComponent: Recruiter = new Recruiter(-1,"","","",false)

  background: ThemePalette ='warn'

  selectedMenu:String='Profile'

  constructor() { }

  ngOnInit(): void {
  }

  onSelectMenu(menu:string){

    this.selectedMenu=menu;
  }

}



