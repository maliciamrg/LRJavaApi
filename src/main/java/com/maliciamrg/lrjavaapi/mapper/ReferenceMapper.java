package com.maliciamrg.lrjavaapi.mapper;

import com.maliciamrg.lrjavaapi.dto.AbstractDTO;
import com.maliciamrg.lrjavaapi.model.AbstractEntity;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationTargetException;

@Component
public class ReferenceMapper {

    private final EntityManager em;
    Logger logger = LoggerFactory.getLogger(ReferenceMapper.class);

    public ReferenceMapper(EntityManager em) {
        this.em = em;
    }

    @ObjectFactory
    public <T extends AbstractEntity<?>> T resolve(AbstractDTO<?> sourceDTO,
                                                   @TargetType Class<T> type) {
        T entity = null;
        if (sourceDTO.getIdLocal() != null) entity = em.find(type, sourceDTO.getIdLocal());
        try {
            if (entity == null) {
                entity = type.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            logger.error(e.getMessage());
        }
        return entity;
    }
}