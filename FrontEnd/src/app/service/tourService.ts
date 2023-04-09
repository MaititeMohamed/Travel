import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";


  @Injectable({
    providedIn: 'root'
  })
  
  export class TourService{
    constructor(private http: HttpClient) { }

    public  getAllTourss(): Observable<any> {
        return this.http.get("http://localhost:8081/api/tours/getAllTours");
        
      }
  }