package tests;

import java.util.Arrays;
import java.util.Collection;
 
import org.junit.Test;
import org.junit.Before;
import org.apache.axis2.AxisFault;
import org.apache.axis2.CalculatorTest.CalculatorStub;
import org.apache.axis2.CalculatorTest.CalculatorStub.Multiply;
import org.apache.axis2.CalculatorTest.CalculatorStub.MultiplyResponse;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedMultiplyTest {
   private Integer inputNumber1;
   private Integer inputNumber2;
   private Integer expectedResult;
   private CalculatorStub stub;
   private MultiplyResponse multiplyResponse;
   
   @Before
   public void initialize() throws AxisFault {
      stub = new CalculatorStub();
   }

   // Each parameter should be placed as an argument here
   // Every time runner triggers, it will pass the arguments
   // from parameters we defined in primeNumbers() method
	
   public ParametrizedMultiplyTest (Integer inputNumber1, Integer inputNumber2, Integer expectedResult) {
	   this.inputNumber1 = inputNumber1;
	   this.inputNumber2 = inputNumber2;
	   this.expectedResult = expectedResult;
	   

   }

   @Parameterized.Parameters
   public static Collection inputNumbers() {
      return Arrays.asList(new Integer[][] {
         { 2, 2, 4},
         { 6, -6, -36},
         { -6, -6, 36},
         { 22, 100, 2200},
         { 23, 0, 0}
      });
   }

   // This test will run 4 times since we have 5 parameters defined
   @Test
   public void testMultiply() throws Exception {
	   Multiply multiply = new Multiply();
	   multiply.setIntA(inputNumber1);
	   multiply.setIntB(inputNumber2);
	   multiplyResponse = stub.multiply(multiply);
      System.out.println(" : " + multiplyResponse.getMultiplyResult());
      assertEquals((int)expectedResult, multiplyResponse.getMultiplyResult());
   }
} 	