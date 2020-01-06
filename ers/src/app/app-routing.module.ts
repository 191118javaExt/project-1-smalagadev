import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { NewReimbursementComponent } from './components/new-reimbursement/new-reimbursement.component';
import { HistoryComponent } from './components/history/history.component';
import { ManageReimbursementsComponent } from './components/manage-reimbursements/manage-reimbursements.component';


const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'new_reimbursement',
    component: NewReimbursementComponent
  },
  {
    path: 'history',
    component: HistoryComponent
  },
  {
    path: 'manage_reimbursements',
    component: ManageReimbursementsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
