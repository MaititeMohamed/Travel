import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StorageService } from 'src/app/service/storageService';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  isGuide=false;
  constructor(private storageService : StorageService,private router:Router) { }

  ngOnInit(): void {

    const role=this.storageService.getUser().authorities[0].authority;
    if(role=="Guide"){
      this.isGuide=true;
    }
  }

}
