import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Client } from "../model/clientModel";


  @Injectable({
    providedIn: 'root'
  })
  export class ClientService{
    
    constructor(private http: HttpClient) { }


    public  getAllClients(): Observable<any> {
        return this.http.get("http://localhost:8081/api/clients/getAllClient");
      }
      public  addClient(client:Client):Observable<Client> {
        return this.http.post<Client>("http://localhost:8081/api/clients/addClient",client);
       }
  
       public updateClient(client: Client):Observable<Client> {
        return this.http.put<Client>("http://localhost:8081/api/clients/updateClient",client);
      }
    
  
       public deleteClient(id: number): Observable<any> {
        return this.http.delete<void>("http://localhost:8081/api/clients/deleteClientById/"+id);
      }
  }