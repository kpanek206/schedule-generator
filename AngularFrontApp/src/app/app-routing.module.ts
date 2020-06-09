import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TaskListComponent} from "./task-list/task-list.component";
import {CreateTaskComponent} from "./create-task/create-task.component";
import {UpdateTaskComponent} from "./update-task/update-task.component";
import {TaskDetailsComponent} from "./task-details/task-details.component";
import { LoginFormComponent } from "./login-form/login-form.component";
import { AuthGuard } from "./auth-guard";


const routes: Routes = [
  { path: '', redirectTo: 'tasks', pathMatch: 'full' },
  { path: 'tasks', component: TaskListComponent },
  { path: 'add', component: CreateTaskComponent },
  { path: 'update/:taskId', component: UpdateTaskComponent },
  { path: 'details/:taskId', component: TaskDetailsComponent },
  { path: "login", component: LoginFormComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
