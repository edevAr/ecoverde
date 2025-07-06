package com.genesis.ecoverde.controller;

import com.genesis.ecoverde.entity.GarbageCollectionDay;
import com.genesis.ecoverde.service.GarbageCollectionDayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/garbage-days")
public class GarbageCollectionDayController {

    private final GarbageCollectionDayService service;

    public GarbageCollectionDayController(GarbageCollectionDayService service) {
        this.service = service;
    }

    @GetMapping
    public List<GarbageCollectionDay> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GarbageCollectionDay> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public GarbageCollectionDay create(@RequestBody GarbageCollectionDay day) {
        return service.create(day);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

