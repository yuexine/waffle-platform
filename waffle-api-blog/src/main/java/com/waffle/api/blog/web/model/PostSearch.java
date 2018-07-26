package com.waffle.api.blog.web.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

import java.io.Serializable;

/**
 * @author yuexin
 * @since 1.0
 */
@Getter
@Setter
public class PostSearch extends SpringDataWebProperties.Pageable implements Serializable {

    private static final long serialVersionUID = 8566853544242192048L;

    private String keywords;

    public PostSearch(String keywords, String page, String size) {
        this.keywords = keywords;
        super.setSizeParameter(size);
        super.setPageParameter(page);
    }

    public static PostSearchBuilder keywords(String keywords) {

        return new PostSearchBuilder(keywords);
    }

    @Getter
    public static class PostSearchBuilder {

        private String keywords;

        private String page = "1";

        private String size = "10";

        public PostSearchBuilder(String keywords) {
            this.keywords = keywords;
        }

        public PostSearchBuilder page(String page) {
            this.page = page;
            return this;
        }

        public PostSearchBuilder size(String size) {
            this.size = size;
            return this;
        }

        public PostSearch build() {
            return new PostSearch(keywords, page, size);
        }
    }

}
