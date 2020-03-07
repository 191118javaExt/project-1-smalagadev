import { Component, OnInit } from '@angular/core';
import { ReimbursementService } from '../../services/reimbursement.service';
import { Router } from '@angular/router';
import { Reimbursement } from '../../models/reimbursement';

@Component({
  selector: 'app-manage-reimbursements',
  templateUrl: './manage-reimbursements.component.html',
  styleUrls: ['./manage-reimbursements.component.css']
})
export class ManageReimbursementsComponent implements OnInit {

  constructor(private rs: ReimbursementService, private router: Router) { }

  private reimbursementList: Reimbursement = [];

  ngOnInit() {
    if(JSON.parse(sessionStorage.getItem("currentUser")) == null){
      this.router.navigate(['/']);
    }

    this.rs.managerViewAll().subscribe(
      (response: Reimbursements) => {
        if(response != null){
          console.log(response);
          response.forEach( r =>{
            this.reimbursementList.push(r);
          });
        }
        else{
          console.log("Nothing to display");
        }
      });
  }

  approve(reimbursement_id: number){
    this.status_id = 1;
    this.rs.statusUpdate(reimbursement_id, 1, JSON.parse(sessionStorage.getItem("currentUser")).id);
  }

  deny(reimbursement_id: number){
    this.status_id = 2;
    this.rs.statusUpdate(reimbursement_id, 2, JSON.parse(sessionStorage.getItem("currentUser")).id);
  }
}
