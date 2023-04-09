import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/userModel';
import { StorageService } from 'src/app/service/storageService';
import { UserService } from 'src/app/service/userService';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user!:User;
  constructor( private userService:UserService, private storageService : StorageService,private router:Router) {
    this.user = new User();
   }

  ngOnInit(): void {
    if(this.storageService.isLoggedIn()){
      this.router.navigate(["/home"]);
   }else{
    this.router.navigate(["login"]);
   }
  }

  public login(addForm: NgForm):void{
    this.userService.login(addForm.value).subscribe(
      (response: User) => {
        console.log('token');
        console.log(response);
        addForm.reset();
           this.storageService.saveUser(response.data);
          const firstName=this.storageService.getUserName();
          console.log(firstName); 
          const role=this.storageService.getUser().authorities[0].authority;
          //role
          console.log(role);
          if(role=="Admin"){
            this.router.navigate(["admin"])
          }
          else if(role=="Client"){
            this.router.navigate(["home"])
          }  else if(role=="Guide"){
            this.router.navigate(["guide"])
          }
          else{
            this.router.navigate([""])
          }
      }
    );
  }
}
