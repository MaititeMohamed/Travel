import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/userModel';
import { StorageService } from 'src/app/service/storageService';
import { UserService } from 'src/app/service/userService';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  firstName!:string;
  constructor(private storageService:StorageService,private userService:UserService,private router: Router) { }

  ngOnInit(): void {
     if(this.storageService.isLoggedIn()){
      const email=this.storageService.getUserName();
      this.getUserByEmail(email);
     }
   
   
  }

  public getUserByEmail(email:string):any{
    this.userService.getUserByEmail(email).subscribe(
      (response: User)=> {
        console.log(response.firstName);
        this.firstName=response.firstName;
      },
    );
  }

  public logout(){
    this.storageService.clean();
  }

}
