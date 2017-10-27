package by.tc.task02.service.impl;

import by.tc.task02.dao.DAOFactory;
import by.tc.task02.dao.EntityDAO;
import by.tc.task02.entity.Entity;
import by.tc.task02.entity.exceptions.DAOExceptions;
import by.tc.task02.entity.exceptions.ServiceExceptions;
import by.tc.task02.service.EntityService;

public class EntityServiceImpl implements EntityService{

    @Override
    public Entity getEntity() throws ServiceExceptions {
        try {
            EntityDAO entityDAO = DAOFactory.getInstance().getEntityDAO();
            return entityDAO.find();
        } catch (DAOExceptions e) {
            throw new ServiceExceptions(e.getMessage(), e.getCause());
        }
    }
    
}
