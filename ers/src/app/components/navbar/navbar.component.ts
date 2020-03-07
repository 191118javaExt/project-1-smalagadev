import { Component, OnInit  } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})

export class NavbarComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    isLoggedIn = JSON.parse(sessionStorage.getItem("currentUser")) != null ? true : false;

    if(isLoggedIn){
      this.first_name = JSON.parse(sessionStorage.getItem("currentUser")).first_name;
      this.last_name = JSON.parse(sessionStorage.getItem("currentUser")).last_name;
    }
  }

  private first_name: string = "";
  private last_name: string = "";



  logoutForm(): void{
    const logoutForm = document.getElementById('Logout');
    // Returns error because TypeScript does not recognize Materialize CDN in HTML file
    const instances = M.Modal.init(logoutForm);
  }

}
