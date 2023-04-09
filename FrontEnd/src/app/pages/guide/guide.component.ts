import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Guide } from 'src/app/model/guideModel';
import { GuideService } from 'src/app/service/guideService';
import { StorageService } from 'src/app/service/storageService';

@Component({
  selector: 'app-guide',
  templateUrl: './guide.component.html',
  styleUrls: ['./guide.component.css']
})
export class GuideComponent implements OnInit {
  editGuide!: Guide;
  deleteGuide!: Guide;
  guides :Guide[]=[];
  constructor(private guideService:GuideService,private storageService:StorageService, private router: Router) { }

  ngOnInit(): void {
    this.getAllGuides();
  }


  public getAllGuides(){
    this.guideService.getAllGuides().subscribe({
      next: (result) => {
        console.log(result);
        this.guides = result;
        console.log(this.guides);
      },
      error: (e) => console.error(e)
    });
  }



  public addGuide(addForm: NgForm):void{
    this.guideService.addGuide(addForm.value).subscribe(
      (response: Guide) => {
        console.log(response);
        this.getAllGuides();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public updateGuide(guide: Guide): void {
    this.guideService.updateGuidet(guide).subscribe(
      (response: Guide) => {
        console.log(response);
        this.getAllGuides();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public deleteGuideById(id: number): void {
    this.guideService.deleteGuide(id).subscribe(
      (response: void) => {
        console.log(response);
        this.getAllGuides();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public onOpenModal(guide: Guide, mode: string): void {
    const container = document.getElementById('main');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');
    if (mode === 'edit') {
      this.editGuide =guide;
      button.setAttribute('data-bs-target', '#updateClient');
    }
    if (mode === 'delete') {
      this.deleteGuide = guide;
      button.setAttribute('data-bs-target', '#deleteClient');
    }
   container!.appendChild(button);
    button.click();
  }

}
