package com.maze.factorymethod;

import com.maze.Wall;

public class BombMazeGame extends MazeGameUseFactory{

	Wall makeWall() {
		// return BomberWall();
		return null;
	}
}
