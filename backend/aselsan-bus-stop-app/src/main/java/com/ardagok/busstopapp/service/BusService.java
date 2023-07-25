package com.ardagok.busstopapp.service;

import com.ardagok.busstopapp.entity.BusEntity;
import com.ardagok.busstopapp.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {
    @Autowired
    private final BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public List<BusEntity> getBuses() {
        return busRepository.findAll();
    }


    public void addNewBus(BusEntity busEntity) {

        busRepository.save(busEntity);
    }
}


