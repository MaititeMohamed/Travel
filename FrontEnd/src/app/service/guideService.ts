import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Guide } from "../model/guideModel";



  @Injectable({
    providedIn: 'root'
  })
  export class GuideService{
    
    constructor(private http: HttpClient) { }

    public  getAllGuides(): Observable<any> {
        return this.http.get("http://localhost:8081/api/guides/getAllGuides");
      }
      public  addGuide(guide:Guide):Observable<Guide> {
        return this.http.post<Guide>("http://localhost:8081/api/guides/addGuide",guide);
       }
  
       public updateGuidet(guide: Guide):Observable<Guide> {
        return this.http.put<Guide>("http://localhost:8081/api/guides/updateGuide",guide);
      }
    
  
       public deleteGuide(id: number): Observable<any> {
        return this.http.delete<void>("http://localhost:8081/api/guides/deleteGuideById/"+id);
      }
  }