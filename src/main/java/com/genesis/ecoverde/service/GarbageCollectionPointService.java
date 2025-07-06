package com.genesis.ecoverde.service;

import com.genesis.ecoverde.entity.GarbageCollectionPoint;
import com.genesis.ecoverde.repository.GarbageCollectionPointRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarbageCollectionPointService {

    private final GarbageCollectionPointRepository repository;

    public GarbageCollectionPointService(GarbageCollectionPointRepository repository) {
        this.repository = repository;
    }

    public List<GarbageCollectionPoint> getAll() {
        return repository.findAll();
    }

    public Optional<GarbageCollectionPoint> getById(Long id) {
        return repository.findById(id);
    }

    public GarbageCollectionPoint create(GarbageCollectionPoint point) {
        return repository.save(point);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
