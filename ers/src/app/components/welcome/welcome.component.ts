import { Component, OnInit } from '@angular/core';
import { LoginFormComponent } from '../login-form/login-form.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  constructor( private router: Router) { }

  ngOnInit() {
    if(JSON.parse(sessionStorage.getItem("currentUser")).role_id >= 1){
      this.router.navigate(['/home']);
    }

    if(JSON.parse(sessionStorage.getItem("currentUser")).role_id == 0){
      this.router.navigate(['/manager_home']);
    }
  }

 ngAfterContentInit(){

 }




}
