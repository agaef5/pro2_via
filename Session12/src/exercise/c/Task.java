package exercise.c;

import javafx.util.converter.FloatStringConverter;

public class Task
{
  private String text;
  private long estimatedTime;

  public Task(String text, long estimatedTime){
    this.text = text;
    this.estimatedTime = estimatedTime;
  }

  public String getText(){
    return text;
  }

  public long getEstimatedTime()
  {
    return estimatedTime;
  }

  public void setEstimatedTime(long estimatedTime)
  {
    this.estimatedTime = estimatedTime;
  }

  @Override public String toString()
  {
    return super.toString();
  }
}
