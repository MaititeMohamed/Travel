import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Client } from 'src/app/model/clientModel';
import { ClientService } from 'src/app/service/clientService';
import { StorageService } from 'src/app/service/storageService';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private clientService: ClientService,private storageService:StorageService, private router: Router) { }

  ngOnInit(): void {
  }
  
  public addClient(addForm: NgForm):void{
    this.clientService.addClient(addForm.value).subscribe(
      (response: Client) => {
        console.log(response);
        addForm.reset();
        alert('Acount has been created');
        this.router.navigate(["login"]);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
}


}