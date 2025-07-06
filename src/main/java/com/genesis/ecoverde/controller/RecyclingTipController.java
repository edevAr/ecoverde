package com.genesis.ecoverde.controller;

import com.genesis.ecoverde.entity.RecyclingTip;
import com.genesis.ecoverde.service.RecyclingTipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    private final RecyclingTipService service;

    public RecyclingTipController(RecyclingTipService service) {
        this.service = service;
    }

    @GetMapping
    public List<RecyclingTip> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RecyclingTip create(@RequestBody RecyclingTip tip) {
        return service.create(tip);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
