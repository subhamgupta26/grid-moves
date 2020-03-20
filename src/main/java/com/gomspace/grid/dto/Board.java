package com.gomspace.grid.dto;

import java.util.HashSet;
import java.util.Set;

public class Board {
	
	private Set<Position> blackSquares = new HashSet<>();
	private Machine ant = new Machine();
	private Position topLeftCorner = new Position(0, 0);
	private Position bottomRightCorner = new Position(0,0);
	
	private void flip(Position position) {
		if(blackSquares.contains(new Position(position.getRow(),position.getColumn()))) {
			blackSquares.remove(new Position(position.getRow(),position.getColumn()));
		}else {
			blackSquares.add(new Position(position.getRow(),position.getColumn()));
		}
	}
	
	private void ensureFit(Position position) {
		topLeftCorner.setRow(Math.min(topLeftCorner.getRow(), position.getRow()));
		topLeftCorner.setColumn(Math.min(topLeftCorner.getColumn(), position.getColumn()));
		
		bottomRightCorner.setRow(Math.max(bottomRightCorner.getRow(), position.getRow()));
		bottomRightCorner.setColumn(Math.max(bottomRightCorner.getColumn(), position.getColumn()));
	}
	
	public void move() {
		ant.turn(!blackSquares.contains(ant.getPosition()));
		flip(ant.getPosition());
		ant.setPosition(ant.move(ant.getPosition()));
		ensureFit(ant.getPosition());
	}
	
	public boolean isWhite(int row, int column) {
		boolean value =  blackSquares.contains(new Position(row, column));
		return !value;
	}
	
	public String printBoard() {
		StringBuilder sb = new StringBuilder();
		for(int i=topLeftCorner.getRow();i<=bottomRightCorner.getRow();i++) {
			for(int j=topLeftCorner.getColumn();j<=bottomRightCorner.getColumn();j++) {
				if(ant.getPosition().getRow() == i && ant.getPosition().getColumn() == j) {
					sb.append("A");
				}else 
					if(isWhite(i, j)) {
					sb.append("W");
				}else {
					sb.append("B");
				}
			}
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}
}
