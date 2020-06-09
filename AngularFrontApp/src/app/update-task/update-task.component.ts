import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {Task} from "../task";
import {TaskService} from "../task.service";

@Component({
  selector: 'app-update-task',
  templateUrl: './update-task.component.html',
  styleUrls: ['./update-task.component.css']
})
export class UpdateTaskComponent implements OnInit {

  taskId: number;
  task: Task;
  submitted = false;

  constructor(private route: ActivatedRoute,private router: Router,
              private taskService: TaskService) { }

  ngOnInit(): void {
    this.task = new Task();

    this.taskId = this.route.snapshot.params['taskId'];

    this.taskService.getTask(this.taskId)
      .subscribe(data => {
        console.log(data)
        this.task = data;
      }, error => console.log(error));
  }
  updateTask() {
    this.taskService.updateTask(this.taskId, this.task)
      .subscribe(data => console.log(data), error => console.log(error));
    this.task = new Task();
    this.gotoList();
  }

  onSubmit() {
    this.updateTask();
  }

  gotoList() {
    this.router.navigate(['/tasks']);
  }

}
