import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Tour } from "../model/tourModel";


  @Injectable({
    providedIn: 'root'
  })
  
  export class TourService{
    constructor(private http: HttpClient) { }

    public  getAllTours(): Observable<any> {
        return this.http.get("http://localhost:8081/api/tours/getAllTours");
        
      }

      public  addTour(tour:Tour):Observable<Tour> {
        return this.http.post<Tour>("http://localhost:8081/api/tours/addTour",tour);
       }
  
       public updateTour(tour: Tour):Observable<Tour> {
        return this.http.put<Tour>("http://localhost:8081/api/tours/updateTour",tour);
      }
    
  
       public deleteTour(id: number): Observable<any> {
        return this.http.delete<void>("http://localhost:8081/api/tours/deleteTourById/"+id);
      }




  }