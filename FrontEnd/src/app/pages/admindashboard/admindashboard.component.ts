import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StorageService } from 'src/app/service/storageService';

@Component({
  selector: 'app-admindashboard',
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.css']
})
export class AdmindashboardComponent implements OnInit {


  constructor(private storageService : StorageService,private router:Router) { }

  ngOnInit(): void {
    if(this.storageService.isLoggedIn()){
      if (!(this.storageService.getAuthority() =="Admin" ||this.storageService.getAuthority()=="Gide")){
        this.router.navigate(["login"]);
      }
     
    }else{
      this.router.navigate(["login"]);
    }
  }

}
