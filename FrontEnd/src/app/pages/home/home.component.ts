import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/userModel';
import { StorageService } from 'src/app/service/storageService';
import { TourService } from 'src/app/service/tourService';
import { UserService } from 'src/app/service/userService';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  tours: any;
  firstName!:string;
  userService: any;
  
  constructor(private tourService:TourService,private storageService:StorageService, private router: Router,userService:UserService,) { }
  statusLogin=false;
  ngOnInit(): void {
    if(this.storageService.isLoggedIn()){
      this.statusLogin=true;
      const email=this.storageService.getUserName();
      this.getUserByEmail(email);
     }
     this.getAllTours();
  }


  public getAllTours(){
    this.tourService.getAllTourss().subscribe({
      next: (result) => {
        console.log(result);
        this.tours = result;
        console.log(this.tours);
      },
      error: (e) => console.error(e)
    });
  }
  public getUserByEmail(email:string):any{
    this.userService.getUserByEmail(email).subscribe(
      (response: User)=> {
        console.log(response.firstName);
        this.firstName=response.firstName;
      },
    );
  }

}
