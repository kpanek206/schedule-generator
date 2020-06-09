package com.schedule.schedule.api;


import com.schedule.schedule.model.Task;
import com.schedule.schedule.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
@CrossOrigin
public class TaskResource {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task addTask(@RequestBody  Task task){
        return taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @GetMapping(value = "/{taskId}")
    public Task getTask(@PathVariable("taskId") int taskId){ return taskService.getTask(taskId);
    }

    @PutMapping(value = "/{taskId}")
    public Task updateTask(@PathVariable("taskId") int taskId,  @RequestBody  Task task){
        return taskService.updateTask(taskId, task);
    }

    @DeleteMapping(value = "/{taskId}")
    public void deleteTask(@PathVariable("taskId") int taskId){
        taskService.deleteTask(taskId);
    }
}
