import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsersDataComponent } from './users-data/users-data.component';
import { AddUserComponent } from './add-user/add-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';

const routes: Routes = [
  { path:"users",component:UsersDataComponent},
  { path:"add",component:AddUserComponent},
  { path:"update/:id",component:UpdateUserComponent},
  { path:"", redirectTo:"users", pathMatch:"full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
