import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reservation } from 'src/app/model/reservationModel';
import { ReservationService } from 'src/app/service/reservationService';
import { StorageService } from 'src/app/service/storageService';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {
  editReservation!: Reservation;
  deleteReservation!: Reservation;
  reservations :Reservation[]=[];
  constructor(private reservatinService:ReservationService,private storageService:StorageService, private router: Router) { }

  ngOnInit(): void {
    this.getAllReservations();
  }

  public getAllReservations(){
    this.reservatinService.getAllReservations().subscribe({
      next: (result) => {
        console.log(result);
        this.reservations = result;
        console.log(this.reservations);
      },
      error: (e) => console.error(e)
    });
  }

}
