package org.gof.phew.shared.maze;

import java.util.List;

import com.badlogic.gdx.math.Vector2;

/**
 * 
 */
public class MazeElement
{
	/**
	 * 			"name" : "testshape",
			"location" : { "x" : 100, "y" : 100 },
		    "vertices" : [
		    	{"x" : 10, "y" : 20},
		    	{"x" : 10, "y" : 20},
		    	{"x" : 10, "y" : 20},
		    	{"x" : 10, "y" : 20}
		    	],
		    "angle" : 0,
			"anchor" : null,
			"velocity" : null,
			"momentum" : null
	 */
	
	/**
	 * element name
	 */
	private String name;

	/** 
	 * element mass center location? 
	 */
	private Vector2 location;
	
	/**
	 * element shape vertices
	 */
	private List <Vector2> vertices;
	
	/**
	 * element axis angle
	 */
	private double angle;
	
	/**
	 * lement joint point
	 */
	private Vector2 anchor;
	
	/**
	 * mass center velocity
	 */
	private Vector2 velocity;
	
	/**
	 * rotation momentum
	 */
	private Vector2 momentum;
}
