package com.toy.robot.rest.client;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.toy.robot.inout.InputOutput;
import com.toy.robot.inout.RobotNameList;

/**
 * This class is used to test the robot Restful services.
 */
public class RobotRestClient {
	
	private static String url;
	private String name;
	private String angle;
	private int x_pos;
	private int y_pos;
	
	private ClientConfig config = new ClientConfig();
	private Client client = ClientBuilder.newClient(config);
	private WebTarget target;

	/*
	 * This is a main method to call the rest services that exposes behavior of robot.
	 */
	public static void main(String[] args) {
		
		RobotRestClient restClient = new RobotRestClient();
		
		restClient.loadConfigurationProperties();
		
		restClient.target = restClient.client.target(url);
    	
		restClient.createRobotInRepository();
		restClient.getRobotList();
		restClient.placeRobotOnPlatform();
		restClient.changeRobotDirectionToLeft();
		restClient.changeRobotDirectionToRight();
		restClient.moveRobot();
		restClient.reportRobotPosition();
		  
		}
	
	/*
	 * This method is used to test the service that creates the robot in repository 
	 */
	public void createRobotInRepository ()
	{
		System.out.println("\nRobot creation started\n");
		Response response = target.path(name).request()
				.post(Entity.entity("", MediaType.TEXT_PLAIN),Response.class);
		System.out.println(response);
		if(response.getStatus() == 200)
		{
			System.out.println("\nRobot created successfully.");
		}	
	}
	
	/*
	 * This method is used to test the service that returns the list of robot from repository
	 */
	public void getRobotList ()
	{
		System.out.println("\nList of robots which have been created in robot repository\n");
		Response response = target.path("list").request()
		        .accept(MediaType.APPLICATION_JSON).get(Response.class);
		System.out.println(response+"\n");
		if(response.getStatus() == 200 && response.hasEntity())
		{
			System.out.println(response.readEntity(RobotNameList.class).getRobotNameList());
		}
	}
	
	/*
	 * This method is used to test the service that places the robot on platform.
	 */
	public void placeRobotOnPlatform ()
	{
		System.out.println("\nTrying to position the robot on platform\n");
		InputOutput inout = new InputOutput();
		inout.setAngle(angle);
		inout.setX_pos(x_pos);
		inout.setY_pos(y_pos);
		Response response = target.path(name).path("position").request()
				.post(Entity.entity(inout, MediaType.APPLICATION_JSON),Response.class);
		System.out.println(response+"\n");
		if(response.getStatus() == 200 && response.hasEntity())
		{
			inout = response.readEntity(InputOutput.class);
			System.out.println(inout.toString());
		}
	}
	
	/*
	 * This method is used to test the service that changes the direction of robot to right on the platform.
	 */
	public void changeRobotDirectionToRight ()
	{
		System.out.println("\nChanging the direction of robot towards Right\n");
		Response response = target.path(name).path("position").path("right").request()
				.put(Entity.entity("", MediaType.APPLICATION_JSON),Response.class);

		System.out.println(response+"\n");
		if(response.getStatus() == 200 && response.hasEntity())
		{
			InputOutput inout = response.readEntity(InputOutput.class);
			System.out.println(inout.toString());
		}
	}
	
	/*
	 * This method is used to test the service that changes the direction of robot to left on the platform.
	 */
	public void changeRobotDirectionToLeft ()
	{
		System.out.println("\nChanging the direction of robot towards Left\n");
		Response response = target.path(name).path("position").path("left").request()
		        .put(Entity.entity("", MediaType.APPLICATION_JSON),Response.class);

		System.out.println(response+"\n");
		if(response.getStatus() == 200 && response.hasEntity())
		{
			InputOutput inout = response.readEntity(InputOutput.class);
			System.out.println(inout.toString());
		}
	}
	
	/*
	 * This method is used to test the service that move the robot on the platform.
	 */
	public void moveRobot ()
	{
		System.out.println("\nTrying to move the robot one step forward\n");
		Response response = target.path(name).path("position").path("move").request()
				.put(Entity.entity("", MediaType.APPLICATION_JSON),Response.class);

		System.out.println(response+"\n");
		if(response.getStatus() == 200 && response.hasEntity())
		{
			InputOutput inout = response.readEntity(InputOutput.class);
			System.out.println(inout.toString());
		}
	}
	
	/*
	 * This method is used to test the service that report the position of robot on the platform.
	 */
	public void reportRobotPosition ()
	{
		System.out.println("\nReporting the robot position on platform\n");
		Response response = target.path(name).path("position").request()
		        .accept(MediaType.APPLICATION_JSON).get(Response.class);

		System.out.println(response+"\n");
		if(response.getStatus() == 200 && response.hasEntity())
		{
			InputOutput inout = response.readEntity(InputOutput.class);
			System.out.println(inout.toString());
		}
	}
	
	/*
	 * This method is used to load the configuration from properties file.
	 */
	private void loadConfigurationProperties()
	{
		String configFilePath = System.getProperty("config.file");
		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(new File(configFilePath));
			properties.load(fileInputStream);
			name = properties.getProperty("name");
			url = properties.getProperty("url");
			angle = properties.getProperty("angle");
			x_pos = Integer.parseInt(properties.getProperty("x_pos"));
			y_pos = Integer.parseInt(properties.getProperty("y_pos"));
		}catch (IOException e) {
			System.out.println("Unable to Load File due to error: " + e.getMessage() + ", from path:"+configFilePath);
			e.printStackTrace();
		} finally {
			try {
				if(null != fileInputStream) {
					fileInputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
