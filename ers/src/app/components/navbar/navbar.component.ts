import { Component, OnInit, Input  } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})

export class NavbarComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  @Input() public isLoggedIn: boolean;

  // Opens Login form in Modal
  loginForm(): void{
    const loginForm = document.getElementById('Login');
    // Returns error because TypeScript does not recognize Materialize CDN in HTML file
    const instances = M.Modal.init(loginForm);
  }

  logoutForm(): void{
    const logoutForm = document.getElementById('Logout');
    // Returns error because TypeScript does not recognize Materialize CDN in HTML file
    const instances = M.Modal.init(logoutForm);
  }

}
