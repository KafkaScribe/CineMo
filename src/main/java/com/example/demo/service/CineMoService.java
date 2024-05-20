package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.CineMoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CineMoService {

    @Autowired
    private CineMoRepository cineMoRepository;

    public List<CineMo> getAllCineMos() {
        return cineMoRepository.findAll();
    }

    public void saveCineMo(CineMo cineMo) {
        cineMoRepository.save(cineMo);
    }

    public CineMo getCineMoById(Long id) {
        Optional<CineMo> optionalCineMo = cineMoRepository.findById(id);
        return optionalCineMo.orElse(null);
    }

    public void updateCineMo(Long id, CineMo updatedCineMo) {
        Optional<CineMo> optionalCineMo = cineMoRepository.findById(id);
        optionalCineMo.ifPresent(cineMo -> {
            cineMo.setName(updatedCineMo.getName());
            cineMo.setEmail(updatedCineMo.getEmail());
            cineMo.setUsername(updatedCineMo.getUsername());
            cineMo.setPassword(updatedCineMo.getPassword());
            cineMoRepository.save(cineMo);
        });
    }

    public void deleteCineMo(Long id) {
        cineMoRepository.deleteById(id);
    }
}
