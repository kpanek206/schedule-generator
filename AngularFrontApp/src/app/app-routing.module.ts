import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TaskListComponent} from "./task-list/task-list.component";
import {CreateTaskComponent} from "./create-task/create-task.component";
import {UpdateTaskComponent} from "./update-task/update-task.component";
import {TaskDetailsComponent} from "./task-details/task-details.component";


const routes: Routes = [
  { path: '', redirectTo: 'tasks', pathMatch: 'full' },
  { path: 'tasks', component: TaskListComponent },
  { path: 'add', component: CreateTaskComponent },
  { path: 'tasks/:taskId', component: UpdateTaskComponent },
  { path: 'tasks/:taskId', component: TaskDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
