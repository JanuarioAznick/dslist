package com.nanotechmoz.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nanotechmoz.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}