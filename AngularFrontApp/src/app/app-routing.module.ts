import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TaskListComponent } from "./task-list/task-list.component";
import { CreateTaskComponent } from "./create-task/create-task.component";
import { UpdateTaskComponent } from "./update-task/update-task.component";
import { TaskDetailsComponent } from "./task-details/task-details.component";
import { LoginFormComponent } from "./login-form/login-form.component";
import { AuthGuard } from "./auth-guard";

const routes: Routes = [
  { path: '', redirectTo: 'tasks', pathMatch: 'full' },
  { path: 'tasks', component: TaskListComponent, canActivate: [AuthGuard] },
  { path: 'add', component: CreateTaskComponent, canActivate: [AuthGuard] },
  { path: 'update/:taskId', component: UpdateTaskComponent, canActivate: [AuthGuard] },
  { path: 'details/:taskId', component: TaskDetailsComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginFormComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
