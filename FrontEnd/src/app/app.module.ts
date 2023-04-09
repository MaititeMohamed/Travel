import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { AdmindashboardComponent } from './pages/admindashboard/admindashboard.component';
import { GuidedashboardComponent } from './pages/guidedashboard/guidedashboard.component';
import { FooterComponent } from './layout/footer/footer.component';
import { NavbarComponent } from './layout/navbar/navbar.component';
import { SidebarComponent } from './layout/sidebar/sidebar.component';
import { FormsModule } from '@angular/forms';
import { ClientComponent } from './pages/client/client.component';
import { TourComponent } from './pages/tour/tour.component';
import { ReservationComponent } from './pages/reservation/reservation.component';
import { GuideComponent } from './pages/guide/guide.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    AdmindashboardComponent,
    GuidedashboardComponent,
    FooterComponent,
    NavbarComponent,
    SidebarComponent,
    ClientComponent,
    TourComponent,
    ReservationComponent,
    GuideComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
