package by.tc.task02.dao;

import by.tc.task02.entity.Entity;
import by.tc.task02.entity.exceptions.DAOExceptions;

public interface EntityDAO {
    Entity find()throws DAOExceptions;
}
