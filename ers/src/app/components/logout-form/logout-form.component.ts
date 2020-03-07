import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from '../../models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout-form',
  templateUrl: './logout-form.component.html',
  styleUrls: ['./logout-form.component.css']
})
export class LogoutFormComponent implements OnInit {

  constructor(private us: UserService, private router: Router) { }

  ngOnInit() {
  }

  @Input() public isLoggedIn: boolean;

  @Output() public loggedOut = new EventEmitter();

  logOut(): void {
    // After testing fully implements

    event.preventDefault();
    // if successful
    this.us.logout();
    this.isLoggedIn = false;
    this.loggedOut.emit(this.isLoggedIn);
    sessionStorage.removeItem('currentUser');
    // If successful close modal
    const logoutForm = document.getElementById('Logout');
    // Returns error because TypeScript does not recognize Materialize CDN in HTML file
    const instances = M.Modal.init(logoutForm).close();
    this.router.navigate(['']);
  }

  close(): void {
    event.preventDefault();
    // If successful close modal
    const loginForm = document.getElementById('Logout');
    // Returns error because TypeScript does not recognize Materialize CDN in HTML file
    const instances = M.Modal.init(loginForm).close().outDuration();
  }
}
