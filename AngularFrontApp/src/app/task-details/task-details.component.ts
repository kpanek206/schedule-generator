import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {TaskService} from "../task.service";
import {Task} from "../task";

@Component({
  selector: 'app-task-details',
  templateUrl: './task-details.component.html',
  styleUrls: ['./task-details.component.css']
})
export class TaskDetailsComponent implements OnInit {

  taskId: number;
  task: Task;

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

  list(){
    this.router.navigate(['tasks']);
  }
}
