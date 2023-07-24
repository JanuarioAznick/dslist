package com.nanotechmoz.dslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nanotechmoz.dslist.dto.GameListDTO;
import com.nanotechmoz.dslist.dto.GameMinDTO;
import com.nanotechmoz.dslist.dto.ReplacementDTO;
import com.nanotechmoz.dslist.services.GameListService;
import com.nanotechmoz.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> game = gameListService.findList();
		return game;
		
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId){
		List<GameMinDTO> game = gameService.findByList(listId);
		return game;
		
	}
	
	@PostMapping(value = "/{listId}/replacement")
	public void move (@PathVariable Long listId, @RequestBody ReplacementDTO body){
		gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
				
	}

}
