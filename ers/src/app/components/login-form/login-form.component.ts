import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})

export class LoginFormComponent implements OnInit {
  constructor() { }

  ngOnInit() {
  }

  @Input() public isLoggedIn: boolean;

  @Output() public loggedIn = new EventEmitter();

  logIn(): void {
    event.preventDefault();
    // if successful
    this.isLoggedIn = true;
    this.loggedIn.emit(this.isLoggedIn);
    // If successful close modal
    const loginForm = document.getElementById('Login');
    // Returns error because TypeScript does not recognize Materialize CDN in HTML file
    const instances = M.Modal.init(loginForm).close();
  }

  close(): void {
    event.preventDefault();
    // If successful close modal
    const loginForm = document.getElementById('Login');
    // Returns error because TypeScript does not recognize Materialize CDN in HTML file
    const instances = M.Modal.init(loginForm).close().outDuration();
  }

}
