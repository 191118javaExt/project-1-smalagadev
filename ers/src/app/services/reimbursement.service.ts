import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reimbursement } from '../models/reimbursement';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementService {

  constructor(private http: HttpClient) { }

  insert(amount:number, description:string, receipt:object, type_id:number, user_id:number ):Observable<Reimbursement>{
    let body:any = {
      amount: amount,
      description: description,
      receipt: receipt,
      type_id: type_id,
      author: user_id
    }

    return this.http.post<Reimbursement>('http://localhost:8080/project-1/new_reimbursements', body);
  }

  userViewAll(user_id: number):Observable<Reimbursement>{
    let body:any = {
      user_id: user_id
    }

    return this.http.post<Reimbursement>('http://localhost:8080/project-1/reimbursements', body);
  }

  managerViewAll(): Observable<Reimbursement>{
    let body:any = {}

    return this.http.get<Reimbursement>('http://localhost:8080/project-1/reimbursements', body);
  }

  statusUpdate(reimbursement_id: number, statusChange: number, resolver_id: number) :Observable<Reimbursement>{
    let body ={
      resolver: resolver_id,
      reimbursement_id: reimbursement.id,
      status_id: statusChange
    }

    return this.http.post<Reimbursement>('http://localhost:8080/project-1/update_reimbursements', body);
  }
}
