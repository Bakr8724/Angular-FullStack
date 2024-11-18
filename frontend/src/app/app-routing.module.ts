import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { SharedComponent } from './shared/shared.component';
import { AdminComponent } from './admin/admin.component';
import { WorkerComponent } from './worker/worker.component';


const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch:'full'},
  {path: 'login', component: SharedComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'worker', component: WorkerComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
 