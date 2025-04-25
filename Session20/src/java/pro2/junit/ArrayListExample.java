package pro2.junit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListExample
{
  private ArrayList<Integer> intList;

  public ArrayListExample(Integer[] intList){
    this.intList = new ArrayList<>(Arrays.asList(intList));
  }

  public void add(int n){
    intList.add(n);
  }

  public Object[] getListAsAnArray(){
    return this.intList.toArray();
  }
}
