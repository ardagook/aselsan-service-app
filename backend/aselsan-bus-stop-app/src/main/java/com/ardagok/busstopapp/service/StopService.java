package com.ardagok.busstopapp.service;

import com.ardagok.busstopapp.entity.StopEntity;
import com.ardagok.busstopapp.repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StopService {
    @Autowired
    private final StopRepository stopRepository;

    public StopService(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    public List<StopEntity> getBusStops() {
        return stopRepository.findAll();
    }


    public void addNewBusStops(StopEntity stopEntity) {
        stopRepository.save(stopEntity);
    }


    public Optional<StopEntity> findStopById(long id) {

        return stopRepository.findById(id);
    }

    public HashMap<String, LinkedList> getStopsMin() {

        HashMap<String, LinkedList> stopsMinHashMap = new HashMap<>();
        for (StopEntity entity : stopRepository.findAll()) {

            LinkedList arrayList = new LinkedList();
            arrayList.add(entity.getPoint().getX());
            arrayList.add(entity.getPoint().getY());
            arrayList.add(entity.getStopName());


            stopsMinHashMap.put(String.valueOf(entity.getNo()), arrayList);

        }
        return stopsMinHashMap;
    }
}
