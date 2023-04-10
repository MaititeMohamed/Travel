import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Guide } from 'src/app/model/guideModel';
import { ClientService } from 'src/app/service/clientService';
import { GuideService } from 'src/app/service/guideService';
import { StorageService } from 'src/app/service/storageService';

@Component({
  selector: 'app-registerguide',
  templateUrl: './registerguide.component.html',
  styleUrls: ['./registerguide.component.css']
})
export class RegisterguideComponent implements OnInit {

  constructor(private clientService: ClientService,private storageService:StorageService, private router: Router,private guideService:GuideService) { }

  ngOnInit(): void {
  }

  public addGuide(addForm: NgForm):void{
    this.guideService.addGuide(addForm.value).subscribe(
      (response: Guide) => {
        console.log(response);
        alert('Acount has been created');
        this.router.navigate(["login"]);
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

}
