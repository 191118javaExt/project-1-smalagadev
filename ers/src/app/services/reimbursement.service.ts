import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reimbursement } from '../models/reimbursement';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementService {

  constructor(private http: HttpClient) { }

  insert(r:Reimbursement ):Observable<Reimbursement>{
    let body:any = {

    }

    return this.http.post<Reimbursement>('http://localhost:8080/reimbursement', body);
  }

  viewAll():Observable<Reimbursement>{
    let body:any = {}

    return this.http.post<Reimbursement>('http://localhost:8080/reimbursement', body);
  }
}
