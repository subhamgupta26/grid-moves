package com.gomspace.grid.dto;

public enum Orientation {
	left,right,up,down;
	
	public Orientation getTurn(boolean clockwise) {
		if(this==left) {
		return clockwise?up:down;
		}
		 if(this==up) {
			return clockwise? right: left;
		}
		if(this == right) {
			return clockwise ? down: up;
		}
		else {
			return clockwise? left:right;
		}
	}
}
