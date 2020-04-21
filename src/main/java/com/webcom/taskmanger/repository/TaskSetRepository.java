package com.webcom.taskmanger.repository;

import com.webcom.taskmanger.entity.TaskSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskSetRepository extends JpaRepository<TaskSet, Long> {

    @Query("select ts from TaskSet ts where ts.deleted = false and ts.name = :name")
    TaskSet findByName(@Param("name") String name);

    @Query("select ts from TaskSet ts where ts.deleted = false order by ts.lastChangeDate desc")
    List<TaskSet> getAllTaskSets();
}
