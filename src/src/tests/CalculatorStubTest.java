package tests;

import org.apache.axis2.AxisFault;
import org.apache.axis2.CalculatorTest.CalculatorStub;
import org.apache.axis2.CalculatorTest.CalculatorStub.Add;
import org.apache.axis2.CalculatorTest.CalculatorStub.AddResponse;
import org.apache.axis2.CalculatorTest.CalculatorStub.Divide;
import org.apache.axis2.CalculatorTest.CalculatorStub.DivideResponse;
import org.apache.axis2.CalculatorTest.CalculatorStub.Multiply;
import org.apache.axis2.CalculatorTest.CalculatorStub.MultiplyResponse;
import org.apache.axis2.CalculatorTest.CalculatorStub.Subtract;
import org.apache.axis2.CalculatorTest.CalculatorStub.SubtractResponse;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorStubTest {

	@Test
	public void testDivide_SimpleValues_Calculated() throws Exception {
		
		//Arrange
		CalculatorStub stub = new CalculatorStub("http://www.dneonline.com/calculator.asmx");		
		Divide testData = new Divide();
		testData.setIntA(10);
		testData.setIntB(5);
		
		//Act
		DivideResponse divideResponse = stub.divide(testData);
		
		//Assert		
		assertEquals(2, divideResponse.getDivideResult());
	}
	
	@Test (expected = AxisFault.class)
	public void testDivide_ZeroDenominator_Exception() throws Exception {
		
		//Arrange
		CalculatorStub stub = new CalculatorStub("http://www.dneonline.com/calculator.asmx");		
		Divide testData = new Divide();
		testData.setIntA(10);
		testData.setIntB(0);
		
		//Act
		stub.divide(testData);
	}

	@Test
	public void testAdd_SimpleValues_Calculated() throws Exception {
		
		//Arrange
		CalculatorStub stub = new CalculatorStub("http://www.dneonline.com/calculator.asmx");		
		Add testData = new Add();
		testData.setIntA(10);
		testData.setIntB(5);
		
		//Act
		AddResponse addResponse = stub.add(testData);
		
		//Assert		
		assertEquals(15, addResponse.getAddResult());
	}

	@Test
	public void testMultiply_SimpleValues_Calculated() throws Exception {
		
		//Arrange
		CalculatorStub stub = new CalculatorStub("http://www.dneonline.com/calculator.asmx");		
		Multiply testData = new Multiply();
		testData.setIntA(10);
		testData.setIntB(5);
		
		//Act
		MultiplyResponse multiplyResponse = stub.multiply(testData);
		
		//Assert		
		assertEquals(50, multiplyResponse.getMultiplyResult());
	}

	@Test
	public void testSubtract_SimpleValues_Calculated() throws Exception {
		
		//Arrange
		CalculatorStub stub = new CalculatorStub("http://www.dneonline.com/calculator.asmx");		
		Subtract testData = new Subtract();
		testData.setIntA(10);
		testData.setIntB(5);
		
		//Act
		SubtractResponse subtractResponse = stub.subtract(testData);
		
		//Assert		
		assertEquals(5, subtractResponse.getSubtractResult());
	}

}
