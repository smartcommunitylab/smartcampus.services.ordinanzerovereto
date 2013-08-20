package eu.trentorise.smartcampus.services.ordinanzerovereto.impl;

import it.sayservice.platform.core.common.exception.EntityNotFoundException;
import it.sayservice.platform.core.bus.common.exception.PersistenceException;
import it.sayservice.platform.core.bus.data.mongo.AbstractMongoPersistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.Message;
import com.mongodb.DB;

public class GetOrdinanzeServicePersistence extends AbstractMongoPersistence {

    public GetOrdinanzeServicePersistence(DB db) {
        super(db);
    }

    @Override
    protected String getServiceId() {
        return "eu.trentorise.smartcampus.services.ordinanzerovereto.OrdinanzeRoveretoService";
    }

    @Override
    protected String getMethodName() {
        return "GetOrdinanze";
    }

    @Override
    protected Builder<?> getProtoBuilder() {
        return eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.Ordinanzerovereto.Ordinanza .newBuilder();
    }

    @Override
    protected Class<?> getParamType(String param) {
        return null;
    }
    
}
