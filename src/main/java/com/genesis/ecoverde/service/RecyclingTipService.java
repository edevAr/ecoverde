package com.genesis.ecoverde.service;

import com.genesis.ecoverde.entity.RecyclingTip;
import com.genesis.ecoverde.repository.RecyclingTipRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecyclingTipService {

    private final RecyclingTipRepository repository;

    public RecyclingTipService(RecyclingTipRepository repository) {
        this.repository = repository;
    }

    public List<RecyclingTip> getAll() {
        return repository.findAll();
    }

    public Optional<RecyclingTip> getById(Long id) {
        return repository.findById(id);
    }

    public RecyclingTip create(RecyclingTip tip) {
        return repository.save(tip);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
