import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginFormComponent } from './components/login-form/login-form.component';
import { LogoutFormComponent } from './components/logout-form/logout-form.component';
import { HomeComponent } from './components/home/home.component';
import { NewReimbursementComponent } from './components/new-reimbursement/new-reimbursement.component';
import { HistoryComponent } from './components/history/history.component';
import { ManageReimbursementsComponent } from './components/manage-reimbursements/manage-reimbursements.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { ManagerHomeComponent } from './components/manager-home/manager-home.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginFormComponent,
    LogoutFormComponent,
    HomeComponent,
    NewReimbursementComponent,
    HistoryComponent,
    ManageReimbursementsComponent,
    WelcomeComponent,
    ManagerHomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
