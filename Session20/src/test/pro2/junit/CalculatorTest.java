package pro2.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest {

  @Test void add()
  {
//    create CUT/OUT - object under test - an instance of Calculator
    Calculator calculator = new Calculator();
//    execute test by calling the method to toest
    double result = calculator.add(1, 3);
//    check the resultof thte test
    assertEquals(4, result);
  }

  @Test void testAdd()
  {
  }
}