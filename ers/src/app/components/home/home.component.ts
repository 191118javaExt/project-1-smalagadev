import { Component, OnInit } from '@angular/core';
import { HistoryComponent } from '../history/history.component';
import { NewReimbursementComponent } from '../new-reimbursement/new-reimbursement.component';
import { User } from '../../models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(private router: Router) { }

  ngOnInit() {
    if(JSON.parse(sessionStorage.getItem("currentUser")) == null){
      this.router.navigate(['/']);
    }
  }

  ngAfterContentInit(){
  }

  currentUser: User = JSON.parse(sessionStorage.getItem("currentUser"));
}
