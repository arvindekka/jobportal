import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeCandidateComponent } from './home-candidate/home-candidate.component';
import { SuggestionComponent } from './suggestion/suggestion.component';

const routes: Routes = [
  { path: 'suggestion', component: SuggestionComponent }, 
  { path: 'homeCandidate', component: HomeCandidateComponent }, 


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
