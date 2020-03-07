import { Component, OnInit } from '@angular/core';
import { ReimbursementService } from '../../services/reimbursement.service';
import { Reimbursement } from '../../models/reimbursement';
@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  constructor(private rs: ReimbursementService) { }

  private reimbursementHistory: Reimbursement[] = [];

  ngOnInit() {
    this.rs.userViewAll(JSON.parse((sessionStorage.getItem("currentUser"))).id).subscribe(
      (response: Reimbursements) => {
        if(response != null){
          console.log(response);
          response.forEach( r =>{
            this.reimbursementHistory.push(r);
          });
        }
        else{
          console.log("Nothing to display");
        }
      });
  }

}
