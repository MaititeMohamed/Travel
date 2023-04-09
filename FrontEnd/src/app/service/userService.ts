import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { User } from "../model/userModel";


  @Injectable({
    providedIn: 'root'
  })
  export class UserService{
    constructor(private http: HttpClient) { }


    public login(user:User):Observable<User>{
        return this.http.post<User>("http://localhost:8081/authenticate/login",user);
    }



    public getUserByEmail(email:string):Observable<User>{
        return this.http.get<User>("http://localhost:8081/api/users/getUserByEmail/"+email);
      }



  }