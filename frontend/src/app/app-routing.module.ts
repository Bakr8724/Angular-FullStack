import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { SharedComponent } from './shared/shared.component';
import { AdminComponent } from './admin/admin.component';
import { WorkerComponent } from './worker/worker.component';
import { AnnouncementsComponent } from './announcements/announcements.component';
import { TeamsComponent } from './teams/teams.component';
import { UsersComponent } from './users/users.component';
import  {CompanyComponent} from './company/company.component';
const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch:'full'},
  {path: 'login', component: SharedComponent},
  {path: 'company', component: CompanyComponent},
  {path: 'worker', component: WorkerComponent},
  {path: 'announcements', component: AnnouncementsComponent},
  {path: 'teams', component: TeamsComponent},
  {path: 'users', component: UsersComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
 