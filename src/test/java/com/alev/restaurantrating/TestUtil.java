package com.alev.restaurantrating;

import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import com.alev.restaurantrating.matcher.ModelMatcher;
import com.alev.restaurantrating.model.User;

import java.io.UnsupportedEncodingException;

public class TestUtil {

    private TestUtil() {
    }

    public static ResultActions print(ResultActions action) throws UnsupportedEncodingException {
        System.out.println(getContent(action));
        return action;
    }

    public static String getContent(ResultActions action) throws UnsupportedEncodingException {
        return action.andReturn().getResponse().getContentAsString();
    }

    public static RequestPostProcessor userHttpBasic(User user) {
        return SecurityMockMvcRequestPostProcessors.httpBasic(user.getEmail(), user.getPassword());
    }

    /**
     * Compare entities using toString
     */
    public static class ToStringModelMatcher<T> extends ModelMatcher<T, String> {
        public ToStringModelMatcher(Class<T> entityClass) {
            super(Object::toString, entityClass);
        }
    }
}
