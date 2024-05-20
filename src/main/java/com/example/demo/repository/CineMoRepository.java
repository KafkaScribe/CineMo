package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.service.CineMo;

public interface CineMoRepository extends JpaRepository<CineMo, Long> {

}