import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-suggestion',
  templateUrl: './suggestion.component.html',
  styleUrls: ['./suggestion.component.css']
})
export class SuggestionComponent implements OnInit {

  name="arvind"
  mouse?:any = false;
  constructor(private router: Router) {

    //This works only in constructors
    console.log(this.router.getCurrentNavigation()?.extras?.state);
    // this.mouse =  
    
    // let promise = new Promise();
    // this.router.getCurrentNavigation()?.extras?.state[0];

   }

  ngOnInit(): void {

    //This works only in constructors
    console.log(history.state)

    console.log(history.state)
    this.mouse = history.state.loggedIn;

  }

}
