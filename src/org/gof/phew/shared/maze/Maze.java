package org.gof.phew.shared.maze;

import java.util.List;

import org.gof.phew.shared.maze.utils.IO;

public class Maze
{
/	
	/**
	 * short name
	 */
	private String name;
	
	/**
	 * description
	 */
	private String description;
	
	/**
	 * shapes
	 */
	private List <MazeElement> shapes;
	
	
	/**
	 * Loads maze of specified id
	 * 
	 * @param type
	 * @param id
	 * @param kind
	 * @return
	 */
	public static final Maze load(String type, String id, String kind)
	{
		String resourceId = new StringBuilder()
			.append( "levels/" ).append("maze").append("-").append(type)
			.append("-").append(id).append("-").append(kind)
			.toString();
		
		
		/*
		"name" : "Hello Word!",
		"description" : "When you are attracted to, and eat, fruits, occasionally a seed will be carried within you to a fertile ground.", 
		"shapes" : [
			{ 
				... MazeElement
			}]
				
	    */
		return IO.loadObject( resourceId, Maze.class );
	}
}
