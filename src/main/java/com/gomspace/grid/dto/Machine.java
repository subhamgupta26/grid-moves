package com.gomspace.grid.dto;

public class Machine {
	private Position position;
	private Orientation orientation;
	
	
	public Machine(){
		this.position = new Position(0, 0);
		this.orientation = Orientation.right;
	}
	
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public void turn(boolean clockwise) {
		orientation = orientation.getTurn(clockwise);
	}
	
	public Position move(Position position) {
		if(orientation == Orientation.left) {
			position.setColumn(position.getColumn()-1);
		}
		if(orientation == Orientation.right) {
			position.setColumn(position.getColumn()+1);
		}
		if(orientation == Orientation.up) {
			position.setRow(position.getRow()-1);
		}
		if(orientation == Orientation.down) {
			position.setRow(position.getRow()+1);
		}
		return position;
	}
	
	public void adjustPosition(int shiftRow, int shiftColumn) {
		position.setRow(position.getRow()+shiftRow);
		position.setColumn(position.getColumn()+shiftColumn);
	}
}
