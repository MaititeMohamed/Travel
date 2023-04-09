import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Tour } from 'src/app/model/tourModel';
import { StorageService } from 'src/app/service/storageService';
import { TourService } from 'src/app/service/tourService';

@Component({
  selector: 'app-tour',
  templateUrl: './tour.component.html',
  styleUrls: ['./tour.component.css']
})
export class TourComponent implements OnInit {
  editTour!: Tour;
  deleteTour!: Tour;
  tours :Tour[]=[];
  constructor(private tourService:TourService,private storageService:StorageService, private router: Router) { }

  ngOnInit(): void {
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


  public addTour(addForm: NgForm):void{
    this.tourService.addTour(addForm.value).subscribe(
      (response: Tour) => {
        console.log(response);
        this.getAllTours();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }



  public updateTour(tour: Tour): void {
    this.tourService.updateTour(tour).subscribe(
      (response: Tour) => {
        console.log(response);
        this.getAllTours();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public deleteTourById(id: number): void {
    this.tourService.deleteTour(id).subscribe(
      (response: void) => {
        console.log(response);
        this.getAllTours();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }



  public onOpenModal(tour: Tour, mode: string): void {
    const container = document.getElementById('main');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');
    if (mode === 'edit') {
      this.editTour =tour;
      button.setAttribute('data-bs-target', '#updateClient');
    }
    if (mode === 'delete') {
      this.deleteTour = tour;
      button.setAttribute('data-bs-target', '#deleteClient');
    }
   container!.appendChild(button);
    button.click();
  }



}
