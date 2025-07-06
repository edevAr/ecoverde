package com.genesis.ecoverde.controller;

import com.genesis.ecoverde.entity.GarbageCollectionPoint;
import com.genesis.ecoverde.service.GarbageCollectionPointService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/garbage-points")
public class GarbageCollectionPointController {

    private final GarbageCollectionPointService service;

    public GarbageCollectionPointController(GarbageCollectionPointService service) {
        this.service = service;
    }

    @GetMapping
    public List<GarbageCollectionPoint> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GarbageCollectionPoint> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public GarbageCollectionPoint create(@RequestBody GarbageCollectionPoint point) {
        return service.create(point);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
