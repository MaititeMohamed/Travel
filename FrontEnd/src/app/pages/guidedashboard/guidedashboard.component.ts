import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StorageService } from 'src/app/service/storageService';

@Component({
  selector: 'app-guidedashboard',
  templateUrl: './guidedashboard.component.html',
  styleUrls: ['./guidedashboard.component.css']
})
export class GuidedashboardComponent implements OnInit {

  constructor(private storageService : StorageService,private router:Router) { }

  ngOnInit(): void {
    if(this.storageService.isLoggedIn()){
      if (!(this.storageService.getAuthority() =="Guide" )){
        this.router.navigate(["login"]);
      }
     
    }else{
      this.router.navigate(["login"]);
    }
   }

}
