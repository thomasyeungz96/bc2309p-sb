package com.thomas.forum.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thomas.forum.entity.CoinEntity;

// @Repository
public interface UserRepository extends JpaRepository<CoinEntity, Long> {

}
