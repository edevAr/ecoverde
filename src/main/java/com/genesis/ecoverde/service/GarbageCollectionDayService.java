package com.genesis.ecoverde.service;

import com.genesis.ecoverde.entity.GarbageCollectionDay;
import com.genesis.ecoverde.repository.GarbageCollectionDayRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarbageCollectionDayService {

    private final GarbageCollectionDayRepository repository;

    public GarbageCollectionDayService(GarbageCollectionDayRepository repository) {
        this.repository = repository;
    }

    public List<GarbageCollectionDay> getAll() {
        return repository.findAll();
    }

    public Optional<GarbageCollectionDay> getById(Long id) {
        return repository.findById(id);
    }

    public GarbageCollectionDay create(GarbageCollectionDay day) {
        return repository.save(day);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
