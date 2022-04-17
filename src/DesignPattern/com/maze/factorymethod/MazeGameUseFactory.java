package com.maze.factorymethod;

import com.maze.Direction;
import com.maze.Door;
import com.maze.Maze;
import com.maze.MazeFactory;
import com.maze.Room;
import com.maze.Wall;

public class MazeGameUseFactory {
	
	
	Maze makeMaze() {
		return null;
	}
	Wall makeWall() {
		return null;
	}
	Door makeDoor(Room r1,Room r2) {
		return null;
	}
	Room makeRoom(int n) {
		return null;
	}
	

	public void createMaze() {
		Maze maze  = makeMaze();
		Room r1 =makeRoom(1);
		Room r2 = makeRoom(2);
		
		Door door = makeDoor(r1, r2);
		maze.addRoom(r1);
		maze.addRoom(r2);

		r1.setSide(Direction.North, new Wall());
		r1.setSide(Direction.East, door);
		r1.setSide(Direction.South, new Wall());
		r1.setSide(Direction.West, new Wall());
		
		r2.setSide(Direction.North, new Wall());
		r2.setSide(Direction.West, door);
		r2.setSide(Direction.South, new Wall());
		r2.setSide(Direction.East, new Wall());
	}
	
	
	//  工廠方法
	Maze makeMazeUseFactory(MazeFactory mf) {
		
		Maze maze = mf.makeMaze();
		Room r1 = mf.makeRoom(1);
		Room r2 = mf.makeRoom(2);
		Door door = mf.makeDoor(r1, r2);
		
		maze.addRoom(r1);
		maze.addRoom(r2);

		r1.setSide(Direction.North, makeWall());
		r1.setSide(Direction.East, door);
		r1.setSide(Direction.South, makeWall());
		r1.setSide(Direction.West, makeWall());

		r2.setSide(Direction.North, makeWall());
		r2.setSide(Direction.East, makeWall());
		r2.setSide(Direction.South, makeWall());
		r2.setSide(Direction.West, door);
		
		
		return null;
	}



}
