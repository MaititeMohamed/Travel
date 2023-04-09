import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";



  @Injectable({
    providedIn: 'root'
  })
  export class ReservationService{
    
    constructor(private http: HttpClient) { }

    public  getAllReservations(): Observable<any> {
        return this.http.get("http://localhost:8081/api/reservations/getAllReservations");
      }
  }