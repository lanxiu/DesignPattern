package com.maze;

public class MazeGame {
	

	Maze maze  = new Maze();
	Room r1 = new Room(1);
	Room r2 = new Room(2);
	
	Door door = new Door(r1, r2);
	public void makeMaze() {
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
	
	
	// 抽象工廠
	Maze makeMazeUseFactory(MazeFactory mf) {
		
		Maze maze = mf.makeMaze();
		Room r1 = mf.makeRoom(1);
		Room r2 = mf.makeRoom(2);
		Door door = mf.makeDoor(r1, r2);
		
		maze.addRoom(r1);
		maze.addRoom(r2);

		r1.setSide(Direction.North, mf.makeWall());
		r1.setSide(Direction.East, door);
		r1.setSide(Direction.South, mf.makeWall());
		r1.setSide(Direction.West, mf.makeWall());

		r2.setSide(Direction.North, mf.makeWall());
		r2.setSide(Direction.East, mf.makeWall());
		r2.setSide(Direction.South, mf.makeWall());
		r2.setSide(Direction.West, door);
		
		
		return null;
	}

}
