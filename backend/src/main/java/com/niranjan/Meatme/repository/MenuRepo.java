package com.niranjan.Meatme.repository;

import com.niranjan.Meatme.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MenuRepo extends JpaRepository<Menu, Integer> {
}
