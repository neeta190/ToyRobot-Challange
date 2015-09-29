package com.toy.robot.test;

import org.junit.Assert;
import org.junit.Test;

import com.toy.robot.enums.Angle;
import com.toy.robot.factory.RobotFactoryImpl;
import com.toy.robot.factory.RobotFactoryIntf;
import com.toy.robot.main.RobotIntf;

/**
 * 
 * This class is used to test the robot behavior by providing specific input
 * and checking against the corresponding output.
 *
 */
public class RobotTestBehavior {
	
	String name = "Optimus";
	RobotFactoryIntf robofactory = new RobotFactoryImpl();
	
	/*
	 * This method is used to test that the robot that has not been placed 
	 * can't be moved.
	 */
	@Test
	public void RobotInitialisedButNotPlacedCannotBeMoved()
    {
		RobotIntf robot = robofactory.create(name);
		boolean result = robot.move();
		Assert.assertFalse("Robot not yet positioned on platform", result);
    }
	
	/*
	 * This method is used to test that the robot that has not been placed 
	 * can't be turned left or right.
	 */
	@Test
	public void RobotInitialisedButNotPlacedCannotBeTurned()
    {
		RobotIntf robot = robofactory.create(name);
		boolean result = robot.left();
		Assert.assertFalse("Robot cannot turn left until it has been placed on the platform", result);
		
		result = robot.right();
		Assert.assertFalse("Robot cannot turn left until it has been placed on the platform", result);
    }

	/*
	 * This method is used to test that the robot that has not been placed 
	 * can't provide its position.
	 */
	@Test
    public void RobotInitialisedButNotPlacedCannotReportItsPosition()
    {
		RobotIntf robot = robofactory.create(name);
        Assert.assertNull("Robot cannot report it's position until it has been placed on the table.", robot.getRoboPosition());
    }
	
	/*
	 * This method is used to test that the robot can't be placed outside
	 * platform dimensions.
	 */
	@Test
    public void RobotPlacedOffTableCannotBePlaced()
    {
		RobotIntf robot = robofactory.create(name);
        boolean result = robot.place(Angle.NORTH.toString(), -1, 0);
        Assert.assertFalse("Robot cannot be placed outside platform dimensions.", result);

        result = robot.place(Angle.NORTH.toString(),0, 6);
        Assert.assertFalse("Robot cannot be placed outside platform dimensions.", result);
    }

	/*
	 * This method is used to test that the robot with valid XY co-ordinates can placed 
	 * on platform and reports its position.
	 */
	@Test
    public void RobotPlacedCanReportItsPosition()
    {
		RobotIntf robot = robofactory.create(name);
        boolean result = robot.place(Angle.EAST.toString(), 3, 2);
        Assert.assertTrue("Robot successfully placed on platform", result);
        
        String position = robot.getRoboPosition().getAngle().toString() + "," + robot.getRoboPosition().getX_pos() + "," + robot.getRoboPosition().getY_pos();
        Assert.assertEquals("EAST,3,2", position);
    }

	/*
	 * This method is used to test that the robot with valid XY co-ordinates can be turned left
	 * and reports its position.
	 */
	@Test
    public void RobotPlacedAndTurnedLeftReportsCorrectPosition()
    {
		RobotIntf robot = robofactory.create(name);
		boolean result = robot.place(Angle.NORTH.toString(), 1, 1);
		Assert.assertTrue("Robot successfully placed on platform", result);
		
		result = robot.left();
		Assert.assertTrue("Robot can turn left as it has been placed on the platform", result);
		String position = robot.getRoboPosition().getAngle().toString() + "," + robot.getRoboPosition().getX_pos() + "," + robot.getRoboPosition().getY_pos();
	    Assert.assertEquals("WEST,1,1", position);
    }

	/*
	 * This method is used to test that the robot with valid XY co-ordinates can be turned right
	 * and reports its position.
	 */
	@Test
    public void RobotPlacedAndTurnedRightReportsCorrectPosition()
    {
		RobotIntf robot = robofactory.create(name);
		boolean result = robot.place(Angle.NORTH.toString(), 1, 1);
		Assert.assertTrue("Robot successfully placed on platform", result);
		
		result = robot.right();
		Assert.assertTrue("Robot can turn right as it has been placed on the platform", result);
		String position = robot.getRoboPosition().getAngle().toString() + "," + robot.getRoboPosition().getX_pos() + "," + robot.getRoboPosition().getY_pos();
	    Assert.assertEquals("EAST,1,1", position);
    }

	/*
	 * This method is used to test that the robot can't be moved out of platform dimensions
	 * and reports its position.
	 */
	@Test
    public void RobotPlacedAndMovedOffTableCannotBeMoved()
    {
		RobotIntf robot = robofactory.create(name);
		boolean result = robot.place(Angle.NORTH.toString(), 4, 4);
		Assert.assertTrue("Robot successfully placed on platform", result);
		
        result = robot.move();
        Assert.assertFalse("Robot cannot be moved outside platform dimensions.", result);
        
        String position = robot.getRoboPosition().getAngle().toString() + "," + robot.getRoboPosition().getX_pos() + "," + robot.getRoboPosition().getY_pos();
        Assert.assertEquals("NORTH,4,4", position);
    }

	/*
	 * This method is used to test that the robot can be moved with in platform dimensions
	 * and reports accurate position.
	 */
	@Test
    public void RobotPlacedAndMovedReportsCorrectPosition()
    {
		RobotIntf robot = robofactory.create(name);
		boolean result = robot.place(Angle.NORTH.toString(), 1, 1);
		Assert.assertTrue("Robot successfully placed on platform", result);
		
		result = robot.move();
		Assert.assertTrue("Robot moved successfully on the platform", result);
		
		String position = robot.getRoboPosition().getAngle().toString() + "," + robot.getRoboPosition().getX_pos() + "," + robot.getRoboPosition().getY_pos();
        Assert.assertEquals("NORTH,1,2", position);
    }

	/*
	 * This method is used to test that the robot placed accurately can moved with in platform dimensions
	 * and reports accurate position.
	 */
	@Test
    public void RobotPlacedMovedAndTurnedReportsCorrectPosition()
    {
		RobotIntf robot = robofactory.create(name);
		boolean result = robot.place(Angle.EAST.toString(), 1, 2);
		Assert.assertTrue("Robot successfully placed on platform", result);
		
		result = robot.move();
		Assert.assertTrue("Robot moved successfully on the platform", result);
		
		result = robot.move();
		Assert.assertTrue("Robot moved successfully on the platform", result);
		
        result = robot.left();
        Assert.assertTrue("Robot turned Left on the platform", result);
        
        result = robot.move();
        Assert.assertTrue("Robot moved successfully on the platform", result);
        
        String position = robot.getRoboPosition().getAngle().toString() + "," + robot.getRoboPosition().getX_pos() + "," + robot.getRoboPosition().getY_pos();
        Assert.assertEquals("NORTH,3,3", position);
    }

}
