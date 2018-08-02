package com.waffle.api.blog.web.model;

import com.waffle.api.blog.model.Document;
import com.waffle.api.blog.model.Post;
import com.waffle.api.blog.model.Tag;
import com.waffle.api.blog.web.description.PostDescription;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Post 适配器
 *
 * @author yuexin
 * @since 1.0
 */
@Getter
@Setter
public class PostAdapter extends Post {

    private static final long serialVersionUID = 1048467501709852576L;

    public PostAdapter(PostDescription pd) {
        setKeywords(pd.getKeywords());
        setTitle(pd.getTitle());
        setContext(pd.getContext());
        setDocument(new Document(pd.getDocument()));
        setRecommend(false);
        setAuthor(pd.getAuthor());
        setTags(splitKeywords(pd.getKeywords()));
    }

    private Set<Tag> splitKeywords(String keywords) {
        if (keywords.isEmpty()) {
            return null;
        }
        List<String> keywordsList = Arrays.asList(keywords.split(","));
        return keywordsList.stream().map(Tag::new).collect(Collectors.toSet());
    }

}
