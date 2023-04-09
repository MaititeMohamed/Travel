
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { AdmindashboardComponent } from './pages/admindashboard/admindashboard.component';
import { GuidedashboardComponent } from './pages/guidedashboard/guidedashboard.component';
import { ClientComponent } from './pages/client/client.component';
import { TourComponent } from './pages/tour/tour.component';
import { ReservationComponent } from './pages/reservation/reservation.component';
import { GuideComponent } from './pages/guide/guide.component';


const routes: Routes = [
  { path: '', component:HomeComponent  },
  { path: 'home', component:HomeComponent  },
  { path: 'login', component:LoginComponent  },
  { path: 'register', component:RegisterComponent  },
  {path:'admin',component:AdmindashboardComponent},
  {path:'guide',component:GuidedashboardComponent},
  {path:'client',component:ClientComponent},
  {path:'tour',component:TourComponent},
  {path:'reservation',component:ReservationComponent},
  {path:'guides',component:GuideComponent},
];



@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }