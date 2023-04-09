import { Component, OnInit } from '@angular/core';
import { TourService } from 'src/app/service/tourService';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  tours: any;
  
  constructor(private tourService:TourService) { }

  ngOnInit(): void {
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
}
