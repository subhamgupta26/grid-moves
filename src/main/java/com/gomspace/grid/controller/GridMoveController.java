package com.gomspace.grid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gomspace.grid.dto.Board;
import com.gomspace.grid.service.GridMoveService;

@RestController
@RequestMapping("/api")
public class GridMoveController {
	
	@Autowired
	GridMoveService gridMoveService; 

	@GetMapping("/move/{steps}")
	public ResponseEntity  move(@PathVariable("steps") int steps) {

		String output = gridMoveService.move(steps);
		
		String contentType = "application/octet-stream";
		String fileName = "gridMoves.txt";
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
				.body(output.getBytes());
	}
	
	@PutMapping("/move/{steps}")
	public ResponseEntity movePut(@PathVariable("steps") int steps) {
		String output = gridMoveService.move(steps);
		
		String contentType = "application/octet-stream";
		String fileName = "gridMoves.txt";
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
				.body(output.getBytes());
	}
}
