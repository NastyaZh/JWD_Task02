package by.tc.task02.dao.impl;

import by.tc.task02.dao.EntityDAO;
import by.tc.task02.dao.parser.Parser;
import by.tc.task02.entity.Entity;
import by.tc.task02.entity.exceptions.DAOExceptions;

public class EntityDAOImpl implements EntityDAO{

    @Override
    public Entity find() throws DAOExceptions {
        FileWorker file = new FileWorker();
        String xmlFile = file.readFromFile();
        return new Parser().parseXml(xmlFile);
    }
    
}
