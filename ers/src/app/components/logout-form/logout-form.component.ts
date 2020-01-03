import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-logout-form',
  templateUrl: './logout-form.component.html',
  styleUrls: ['./logout-form.component.css']
})
export class LogoutFormComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  @Input() public isLoggedIn: boolean;

  @Output() public loggedOut = new EventEmitter();

  logOut(): void {
    event.preventDefault();
    // if successful
    this.isLoggedIn = false;
    this.loggedOut.emit(this.isLoggedIn);
    // If successful close modal
    const logoutForm = document.getElementById('Logout');
    // Returns error because TypeScript does not recognize Materialize CDN in HTML file
    const instances = M.Modal.init(logoutForm).close();
  }

  close(): void {
    event.preventDefault();
    // If successful close modal
    const loginForm = document.getElementById('Logout');
    // Returns error because TypeScript does not recognize Materialize CDN in HTML file
    const instances = M.Modal.init(loginForm).close().outDuration();
  }
}
