import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Client } from 'src/app/model/clientModel';
import { Reservation } from 'src/app/model/reservationModel';
import { User } from 'src/app/model/userModel';
import { ReservationService } from 'src/app/service/reservationService';
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
  userId: any;
  reservation= new Reservation();
  
  
  constructor(private tourService:TourService,private storageService:StorageService, private router: Router,
    private userService:UserService,private reservationService:ReservationService) { }
  statusLogin=false;
  ngOnInit(): void {
    this.getAllTours();
    if(this.storageService.isLoggedIn()){
      this.statusLogin=true;
      const email=this.storageService.getUserName();
      this.getUserByEmail(email);
     }
     this.getAllTours();
  }


  public getAllTours(){
    this.tourService.getAllTours().subscribe({
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
        this.userId=response.userId;
      },
    );
  }

  public Reservastion(id:number):void{
    this.reservation.client.userId=this.userId;
    this.reservation.tour.id=id;  
    this.reservationService.Reservation(this.reservation).subscribe(
      (response: Reservation) => {
        console.log(response);
        alert('Reservation has been created');
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


  public logout(){
    this.storageService.clean();
    this.router.navigate(["/home"]);
  }

}
