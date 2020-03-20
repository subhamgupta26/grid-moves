package com.gomspace.grid.dto;

public class Position {
	private int row;
	private int column;
	
	
	public Position(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}
	
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Position) {
			Position p = (Position) obj;
			return p.row == this.row && p.column == this.column;
		}
		return false;
	}
	
	
	
	
}
