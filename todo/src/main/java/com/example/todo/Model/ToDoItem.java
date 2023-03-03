package com.example.todo.Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "toDoList")
public class ToDoItem {
  @Id
  @Column(name = "id")
    private String id;
    @Column(name = "task_name")
  private String task_name;
    @Column(name = "task_description")
  private String task_description;
    @Column(name = "due_date")
  private Date due_date;
  @Column(name = "is_completed")
    private String is_completed;

    
public void setId(String id) {
  this.id = id;
}
public void setTask_name(String task_name) {
  this.task_name = task_name;
}
public void setTask_description(String task_description) {
  this.task_description = task_description;
}
public Date getDue_date() {
  return due_date;
}
public void setDue_date(Date due_date) {
  this.due_date = due_date;
}
public String getIs_completed() {
  return is_completed;
}
public void setIs_completed(String is_completed) {
  this.is_completed = is_completed;
}
public String getId() {
  return id;
}
public String getTask_name() {
  return task_name;
}
public String getTask_description() {
  return task_description;
}

}