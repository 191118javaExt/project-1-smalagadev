import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from '../../models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})

export class LoginFormComponent implements OnInit {
  constructor(private us: UserService, private router: Router) { }

  ngOnInit() {
  }

  @Input() public isLoggedIn: boolean;

  @Output() public loggedIn = new EventEmitter();

  username: string = "";
  password: string = "";

  logIn(): void {
    event.preventDefault();

    //HTTP Request
    this.us.login(this.username, this.password).subscribe(
      (response: User) => {
        sessionStorage.setItem('currentUser', JSON.stringify(response));


        if(response != null){
          this.username="";
          this.password="";

          if(response.role_id == 0){
            this.router.navigate(['/manager_home']); //use to forward to next page
          }
          else{
            this.isLoggedIn = true;
            this.router.navigate(['/home']); //use to forward to next page
          }
        }
      });
  }

}
