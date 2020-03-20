package com.gomspace.grid.service;

import org.springframework.stereotype.Service;

import com.gomspace.grid.dto.Board;

@Service
public class GridMoveService {

	public String move(int steps) {
		Board board = new Board();
		for(int i =0;i<steps;i++) {
		board.move();
		}
		return board.printBoard();
	}
}
