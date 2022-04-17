package com.maze;

// 門
public class Door extends MapSite {


	private MapSite Room1;
	private MapSite Room2;
	private boolean IsOpen;
	
	public Door(MapSite room1 ,MapSite room2) {
		
	}
	
	MapSite otherSiderFrom(MapSite room) {
		
		return null;
	}
	
}
