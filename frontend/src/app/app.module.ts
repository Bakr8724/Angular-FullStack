import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SharedComponent } from './shared/shared.component';
import { AdminComponent } from './admin/admin.component';
import { WorkerComponent } from './worker/worker.component';
import { AnnouncementsComponent } from './announcements/announcements.component';
import { TeamsComponent } from './teams/teams.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CompanyComponent } from './company/company.component';
import { UsersComponent } from './users/users.component';
import { TeamsContainerComponent } from './components/teams-container/teams-container.component';
import { TeamCardComponent } from './components/teams-container/team-card/team-card.component';
import { NameCellComponent } from './components/teams-container/team-card/name-cell/name-cell.component';
@NgModule({
  declarations: [
    AppComponent,
    SharedComponent,
    AdminComponent,
    WorkerComponent,
    AnnouncementsComponent,
    TeamsComponent,
    NavbarComponent,
    CompanyComponent,
    UsersComponent,
    TeamsContainerComponent,
    TeamCardComponent,
    NameCellComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
