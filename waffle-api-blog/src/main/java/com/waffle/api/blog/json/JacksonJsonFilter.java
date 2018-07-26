package com.waffle.api.blog.json;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

import java.util.*;

/**
 * @author yuexin
 * @since 1.0
 */
@SuppressWarnings("deprecation")
@JsonFilter("JacksonFilter")
public class JacksonJsonFilter extends FilterProvider {

    Map<Class<?>, Set<String>> includeMap = new HashMap<>();
    Map<Class<?>, Set<String>> filterMap = new HashMap<>();

    @Override
    public BeanPropertyFilter findFilter(Object filterId) {
        throw new UnsupportedOperationException("Access to deprecated filters not supported");
    }

    @Override
    public PropertyFilter findPropertyFilter(Object filterId, Object valueToFilter) {
        return new SimpleBeanPropertyFilter() {
            @Override
            public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer) throws Exception {
                super.serializeAsField(pojo, jgen, provider, writer);
                if (apply(pojo.getClass(), writer.getName())) {
                    writer.serializeAsField(pojo, jgen, provider);
                } else if (!jgen.canOmitFields()) {
                    writer.serializeAsOmittedField(pojo, jgen, provider);
                }
            }
        };
    }

    private boolean apply(Class<?> type, String name) {
        Set<String> includeFields = includeMap.get(type);
        Set<String> filterFields = filterMap.get(type);
        if (includeFields != null && includeFields.contains(name)) {
            return true;
        } else if (filterFields != null && !filterFields.contains(name)) {
            return true;
        } else if (includeFields == null && filterFields == null) {
            return true;
        }
        return false;
    }

    public void include(Class<?> clazz, String... fields) {
        addToMap(includeMap, clazz, fields);
    }

    public void filter(Class<?> clazz, String... fields) {
        addToMap(filterMap, clazz, fields);
    }

    private void addToMap(Map<Class<?>, Set<String>> map, Class<?> type, String[] fields) {
        Set<String> fieldSet = map.getOrDefault(type, new HashSet<>());
        fieldSet.addAll(Arrays.asList(fields));
        map.put(type, fieldSet);
    }
}
