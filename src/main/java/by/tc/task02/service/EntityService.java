package by.tc.task02.service;

import by.tc.task02.entity.Entity;
import by.tc.task02.entity.exceptions.ServiceExceptions;

public interface EntityService {
    Entity getEntity() throws ServiceExceptions;
}
