package by.tc.task02.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ComplexEntity implements Entity{
    private String name;
    
    private final List <Entity> nestedEntities;
    private Map <String, String> attributes;

    public ComplexEntity() {
        nestedEntities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public Map<String, String> getAttributes() {
        return attributes;
    }
    public List<Entity> getNestedEntities() {
        return nestedEntities;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public void addNestedEntities(Entity entity) {
        nestedEntities.add(entity);
    }

    public void removeNestedEntities(Entity entity) {
        nestedEntities.remove(entity);
    }
    public boolean isEmptyNestedEntities() {
        return nestedEntities.isEmpty();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(null == obj || getClass() != obj.getClass()){
            return false;
        }
        ComplexEntity complexEntity = (ComplexEntity)obj;
        
        if(null == name){
            return (name == complexEntity.name);
        }
        else{
            if(!name.equals(complexEntity.name)){
                return false;
            }
        }
        if(!(Objects.equals(nestedEntities, complexEntity.nestedEntities) ||
                Objects.equals(getAttributes(), complexEntity.getAttributes()))){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.name);
        hash = 73 * hash + Objects.hashCode(this.nestedEntities);
        hash = 73 * hash + Objects.hashCode(this.attributes);
        return hash;
    }

    

    @Override
    public String toString() {
        return name +  " " + attributes + " " + nestedEntities;
    }
}
