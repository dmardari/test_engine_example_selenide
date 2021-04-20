package com.example.haba.execution;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ScenarioContext {

    private final Map<String, Object> DATA = new ConcurrentHashMap<>();

    public void cleanup() {
        DATA.clear();
    }

    public void save(String key, Object value) {
        DATA.put(key, value);
    }

    public <T> T get(String key, Class<T> clazz) {
        return clazz.cast(DATA.get(key));
    }

    public void remove(String key) {
        DATA.remove(key);
    }
}
