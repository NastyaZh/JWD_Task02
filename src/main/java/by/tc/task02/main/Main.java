package by.tc.task02.main;
import by.tc.task02.entity.Entity;
import by.tc.task02.service.ServiceFactory;
import by.tc.task02.view.PrintEntity;
import by.tc.task02.entity.exceptions.ServiceExceptions;
import by.tc.task02.service.EntityService;

public class Main {
    public static void main(String[] args){
        try {
            Entity entity;
            ServiceFactory factory = ServiceFactory.getInstance();
            EntityService service = factory.getEntityService();
            entity = service.getEntity();
            PrintEntity.print(entity);
        } 
        catch (ServiceExceptions e) {
            e.printStackTrace();
        }
    }
    
}
