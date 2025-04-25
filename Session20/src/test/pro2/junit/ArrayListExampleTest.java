package pro2.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListExampleTest
{
  private ArrayListExample intList;

  @BeforeEach void setup(){
    System.out.println(this.getClass().getName() + ">>> setting up");
    Integer[] array = {1,2,3,4,5};
    intList = new ArrayListExample(array);

  }

  @Test void add()
  {
    intList.add(10);
    assertArrayEquals(new Integer[]{1,2,3,4,5,10}, intList.getListAsAnArray());
  }
}