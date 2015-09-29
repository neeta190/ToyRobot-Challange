package com.toy.robot.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * This class is used to run the test cases for robot behavior.
 */
public class RobotTestRunner {

		/*
		 * This is a main method that runs the test case.
		 */
	   public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(RobotTestBehavior.class);
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      System.out.println(result.wasSuccessful());
	   }
	} 
