package com.nanotechmoz.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nanotechmoz.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
