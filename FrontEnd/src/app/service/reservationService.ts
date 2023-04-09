import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Reservation } from "../model/reservationModel";



  @Injectable({
    providedIn: 'root'
  })
  export class ReservationService{
    
    constructor(private http: HttpClient) { }

    public  getAllReservations(): Observable<any> {
        return this.http.get("http://localhost:8081/api/reservations/getAllReservations");
      }

    
    public  Reservation(reservation:Reservation):Observable<Reservation> {
      return this.http.post<Reservation>("http://localhost:8081/api/reservations/addReservation",reservation);
     }
  }