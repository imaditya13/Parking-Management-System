package com.Aditya.ParkingManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class ObjectRegistry {
   private Map<String,Object> objectsMap = new HashMap<>();
    public void register(String name, Object object)
    {
        objectsMap.put(name,object);
    }
    public Object getPrototype(String key)
    {
        return objectsMap.get(key);
    }
}
