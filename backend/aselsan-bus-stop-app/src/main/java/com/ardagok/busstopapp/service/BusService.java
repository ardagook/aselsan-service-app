package com.ardagok.busstopapp.service;

import com.ardagok.busstopapp.entity.BusEntity;
import com.ardagok.busstopapp.entity.StopEntity;
import com.ardagok.busstopapp.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public Optional<BusEntity> getBusById(long id) {
        return busRepository.findById(id);
    }


    public HashMap<String, HashMap<String, Object>> getBusesMin() {
        HashMap<String, HashMap<String, Object>> busMinHashMap = new HashMap<>();
        for (BusEntity entity : busRepository.findAll()) {
            HashMap<String, Object> busData = new HashMap<>();
            busData.put("name", entity.getName());

            List<String> stops = new LinkedList<>();
            for (StopEntity entity2 : entity.getBusStop()) {
                stops.add(entity2.getNo());
            }
            List<String> stops2 = new LinkedList<>();
            for (StopEntity entity2 : entity.getBusStop()) {
                stops2.add(entity2.getNo());
            }
            Collections.sort(stops);
            List<List<String>> allStops = new LinkedList<>();
            allStops.add(stops);

            busData.put("routes", allStops);
            busMinHashMap.put(String.valueOf(entity.getNo()), busData);

        }
        return busMinHashMap;
    }
}






