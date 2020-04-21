package com.webcom.taskmanger.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task", schema = "public")
@Getter
@Setter
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Task {

    @Id
    @SequenceGenerator(name = "task_seq", sequenceName = "seq_task", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "completed")
    private Boolean completed;

    @Column(name = "last_change_date")
    private LocalDateTime lastChangeDate;

    @ManyToOne()
    private TaskSet taskSet;
}
