package com.waffle.api.blog.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

/**
 * @author yuexin
 * @since 1.0
 */
public class JsonSerializer {

    private final ObjectMapper mapper = new ObjectMapper();
    private final JacksonJsonFilter filter = new JacksonJsonFilter();

    {
        mapper.setFilterProvider(filter);
    }

    public void filter(Class<?> clazz, String includeField, String filterField) {
        if (clazz == null) {
            return;
        }
        if (!StringUtils.isEmpty(includeField)) {
            filter.include(clazz, includeField.split(","));
        }
        if (!StringUtils.isEmpty(filterField)) {
            filter.include(clazz, filterField.split(","));
        }
        mapper.addMixIn(clazz, filter.getClass());
    }

    public void filter(JSON json) {
        filter(json.clazz(), json.include(), json.filter());
    }

    public String toJson(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }
}
