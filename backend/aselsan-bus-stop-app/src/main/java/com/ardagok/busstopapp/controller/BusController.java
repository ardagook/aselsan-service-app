package com.ardagok.busstopapp.controller;

import com.ardagok.busstopapp.exception.BusIdNotFoundException;
import com.ardagok.busstopapp.entity.BusEntity;
import com.ardagok.busstopapp.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/buses")
public class BusController {
    @Autowired
    public final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping
    public List<BusEntity> getBuses() {
        return busService.getBuses();
    }

    @PostMapping
    public void registerNewBus(@RequestBody BusEntity busEntity) {
        busService.addNewBus(busEntity);
    }

    @GetMapping(path = "/min")
    public Map<String, Map<String, Object>> getBusesMin() {
        return busService.getBusesMin();
    }

    @GetMapping(path = "/routes")
    public Map<String, Object> getRoutesMin() {
        return busService.getRoutesMin();
    }

    @GetMapping(path = "/{id}")
    public BusEntity getBusById(@PathVariable Long id) {
        return busService.getBusById(id).orElseThrow(() -> new BusIdNotFoundException("Bus id " + id + " does not found"));
    }


}

