package org.apache.axis2.CalculatorTest;

import org.apache.axis2.AxisFault;
import org.apache.axis2.CalculatorTest.*;
import org.apache.axis2.CalculatorTest.CalculatorStub;
import org.apache.axis2.CalculatorTest.CalculatorStub.Divide;
import org.apache.axis2.CalculatorTest.CalculatorStub.DivideResponse;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorStubTest {

	@Test
	public void testDivide() throws Exception {
		
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

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testMultiply() {
		fail("Not yet implemented");
	}

	@Test
	public void testSubtract() {
		fail("Not yet implemented");
	}

}
