package com.nanotechmoz.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nanotechmoz.dslist.dto.GameDTO;
import com.nanotechmoz.dslist.dto.GameMinDTO;
import com.nanotechmoz.dslist.entities.Game;
import com.nanotechmoz.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game game = gameRepository.findById(id).get();
		return new GameDTO(game);
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> game = gameRepository.findAll();
		List<GameMinDTO> dto = game.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}

}
