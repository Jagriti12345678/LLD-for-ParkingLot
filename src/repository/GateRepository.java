package repository;

import models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {

    private Map<Long, Gate> gates= new TreeMap();

    public Optional<Gate> findGateBy(Long id){
        if(gates.containsKey(id)){
            return Optional.of(gates.get(id));
        }else{
            return Optional.empty();
        }
    }
}
