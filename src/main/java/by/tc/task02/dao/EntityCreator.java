package by.tc.task02.dao;

import by.tc.task02.entity.Entity;
import by.tc.task02.entity.ComplexEntity;
import by.tc.task02.entity.SimpleEntity;
import java.util.Map;

public class EntityCreator {
        public static Entity createEntity(String name, Map<String, String> attributes) {
        ComplexEntity entity = new ComplexEntity();
        entity.setName(name);
        entity.setAttributes(attributes);
        return entity;
    }

    public static Entity createEntity(String name, String value, Map<String, String> attributes) {
        SimpleEntity entity = new SimpleEntity();
        entity.setName(name);
        entity.setValue(value);
        entity.setAttributes(attributes);
        return entity;
    }
}
