import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { Reimbursement } from '../../models/reimbursement';
import { ReimbursementService } from '../../services/reimbursement.service';

@Component({
  selector: 'app-new-reimbursement',
  templateUrl: './new-reimbursement.component.html',
  styleUrls: ['./new-reimbursement.component.css']
})
export class NewReimbursementComponent implements OnInit {

  constructor(private rs: ReimbursementService) { }

    private amount: number;
    private description: string = "";
    private receipt: any;
    private type: number;
    private author: number;

  ngOnInit() {
    const instance = M.FormSelect.getInstance(document.getElementById("type"));
    this.author = JSON.parse(sessionStorage.getItem("currentUser")).id;
  }

  ngAfterContentInit(){
  }

  onFileSelected(event){
    this.receipt = event.target.files[0];
  }

  onSubmit(){
    if( this.amount > 0){
      if(this.type != undefined){
        if(this.receipt!=undefined){
          alert("Reimbursement Submitted");
          this.rs.insert(this.amount, this.description, this.receipt, Number(this.type), JSON.parse(sessionStorage.getItem("currentUser")).id).subscribe(
            (response) =>{
              console.log(response);
            });
        }
        else{
          alert("Select a Category");
        }
      }
      else{
        alert("File is required");
      }
    }else{
      alert("Amount must be greater than $0.00");
    }
  }
}
