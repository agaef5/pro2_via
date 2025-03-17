package exercise.c;

import java.util.ArrayList;

public class TaskList
{
  private ArrayList<Task> taskList;

  public void Task()
  {
    taskList = new ArrayList<>();
  }

  public synchronized void addTask(Task task){
    taskList.add(task);
  }

  public synchronized Task getAndRemoveNextTask(){
    Task taskToReturn = taskList.getFirst();
    taskList.remove(taskToReturn);
    return taskToReturn;
  }

  public synchronized int size(){
    return taskList.size();
  }

  public String toString(){
    StringBuilder stringToReturn = new StringBuilder();
    int taskNumber = 1;

    for(Task task : taskList){
      stringToReturn.append(taskNumber).append(" ") .append(task.getEstimatedTime()).append(" - ").append(task.getText());
      taskNumber++;
    }

    return stringToReturn.toString();
  }
}