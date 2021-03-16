package com.TestCases;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Test 
{
	public static void main(String[] args) {									
   		Result result = JUnitCore.runClasses(TestCaseLogic.class);					
		for (Failure failure : result.getFailures()) {							
     		System.out.println(failure.toString()+"\n\n");					
  }		
  System.out.println("\n\nTestCases Succesful  "+result.wasSuccessful());					
}		
}
