import { Observable } from "rxjs";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';
import {Task} from "../task";
import {TaskService} from "../task.service";
@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {
  tasks: Observable<[Task]>;

  constructor(private taskService: TaskService, private router: Router) {}

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
    this.tasks = this.taskService.getTasksList();
  }
  deleteTask(taskId: number) {
    this.taskService.deleteTask(taskId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  taskDetails(taskId: number){
    this.router.navigate(['details', taskId]);
  }


  updateTask(taskId: number){
    this.router.navigate(['update', taskId]);
  }
}
