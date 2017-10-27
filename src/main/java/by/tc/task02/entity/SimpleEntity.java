package by.tc.task02.entity;

import java.util.Map;
import java.util.Objects;

public class SimpleEntity implements Entity{
    private String name;
    private String value;
    
     private Map<String, String> attributes;
    
    public SimpleEntity(){}
    
    public String getName(){
        return name;
    }
    public String getValue(){
        return value;
    }
    public Map<String, String> getAttributes() {
        return attributes;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public void setValue(String value){
        this.value = value;
    }
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(null == obj || getClass() != obj.getClass()){
            return false;
        }
        SimpleEntity simpleEntity = (SimpleEntity)obj;
        
        if(null == name){
            return (name == simpleEntity.name);
        }
        else{
            if(!name.equals(simpleEntity.name)){
                return false;
            }
        }
        
        if(null == value){
            return (value == simpleEntity.value);
        }
        else{
            if(!value.equals(simpleEntity.value)){
                return false;
            }
        }
        if(!Objects.equals(getAttributes(), simpleEntity.getAttributes())){
            return false;
        }
        
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.value);
        hash = 59 * hash + Objects.hashCode(this.attributes);
        return hash;
    }

    
    @Override
    public String toString(){
       return this.name + " " + this.value + " " + attributes; 
    }
}
