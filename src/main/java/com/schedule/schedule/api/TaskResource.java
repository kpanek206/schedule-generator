package com.schedule.schedule.api;


import com.schedule.schedule.model.Task;
import com.schedule.schedule.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {

    @Autowired
    private TaskService taskService;


    @RequestMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("successMsg", "Schedule Generator /Code");
        return "Homepage";
    }
    @PostMapping
    public Task addTask(@RequestBody  Task task){
        return taskService.addTask(task);
    }

    @RequestMapping("/getAllTasks")
    public String getTasks(Model model){
        List<Task> taskList = taskService.getTasks();
        model.addAttribute("taskList", taskList);
        return "employeeview";

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
