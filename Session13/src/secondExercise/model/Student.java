package secondExercise.model;

public class Student
{
  private String name;
  private int studentNumber;

  public Student(String name, int studentNumber){
    this.name = name;
    this.studentNumber = studentNumber;
  }

  public String getName()
  {
    return name;
  }

  public int getStudentNumber()
  {
    return studentNumber;
  }

  public void setStudentNumber(int studentNumber)
  {
    this.studentNumber = studentNumber;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Override public String toString()
  {
    return "Student{" + "name='" + name + '\'' + ", studentNumber="
        + studentNumber + '}';
  }
}
