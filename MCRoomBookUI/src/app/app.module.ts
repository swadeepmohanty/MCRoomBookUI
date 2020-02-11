import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { CalendarComponent } from './calendar/calendar.component';
import { RoomsComponent } from './admin/rooms/rooms.component';
import { UsersComponent } from './admin/users/users.component';
import {Routes, RouterModule} from '@angular/router';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [
  {path : 'admin/users', component : UsersComponent},
  {path : 'admin/rooms', component : RoomsComponent},
  {path : '', component : CalendarComponent},
  {path : '404', component : PageNotFoundComponent},
  {path : '**', redirectTo : '/404'}

];

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    CalendarComponent,
    RoomsComponent,
    UsersComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
