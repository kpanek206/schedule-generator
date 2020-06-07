package com.schedule.schedule.service;

import com.schedule.schedule.dao.TaskDAO;
import com.schedule.schedule.exception.TaskNotFoundException;
import com.schedule.schedule.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskService {

    @Autowired
    private TaskDAO taskDao;


    public Task addTask (Task task){
        return taskDao.save(task);
    }

    public List<Task> getTasks(){
        return taskDao.findAll();
    }

    public Task getTask (int taskId){

        Optional<Task> optionalTask = taskDao.findById(taskId);

        if(!optionalTask.isPresent())
            throw new TaskNotFoundException("Task not found...");

        return optionalTask.get();
    }

    public Task updateTask(int taskId, Task task){

        task.setTaskId(taskId);
        return taskDao.save(task);
    }

    public void deleteTask(int taskId){
       taskDao.deleteById(taskId);
    }

}
