package com.schedule.schedule.dao;

import com.schedule.schedule.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDAO extends CrudRepository<Task, Integer>{

    @Override
    List<Task> findAll();
}
