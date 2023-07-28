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

  /* public HashMap<String, LinkedList> getStopsMin() {
        HashMap<String, LinkedList> busMinHashMap = new HashMap<>();
        for (BusEntity entity : busRepository.findAll()){

            LinkedList arrayList = new LinkedList();
            arrayList.add(entity.getName());
            Iterator<StopEntity> itr = entity.getBusStop().iterator();
            while(itr.hasNext()){
                itr.get
            }
            arrayList.add((entity.getBusStop());

            busMinHashMap.put(String.valueOf(entity.getNo()),arrayList);

        }
        return busMinHashMap;
    }
    public void busStopFormatter(){
        for(BusEntity entity: busRepository.findAll() ){

        }
*/
    }





