package com.alev.restaurantrating;

import com.alev.restaurantrating.matcher.ModelMatcher;
import com.alev.restaurantrating.model.Role;
import com.alev.restaurantrating.model.User;
import com.alev.restaurantrating.util.PasswordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

import static com.alev.restaurantrating.model.BaseEntity.START_SEQ;

public class UserTestData {
    private UserTestData() {
    }

    private static final Logger LOG = LoggerFactory.getLogger(UserTestData.class);

    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;

    public static final User USER = new User(USER_ID, "User", "user@yandex.ru", "password", Role.ROLE_USER);
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN, Role.ROLE_USER);

    public static final ModelMatcher<User, TestUser> USER_MATCHER = new ModelMatcher<>(u -> ((u instanceof TestUser) ? (TestUser) u : new TestUser(u)), User.class);

    public static class TestUser extends User {

        public TestUser(User u) {
            this(u.getId(), u.getName(), u.getEmail(), u.getPassword(), u.isEnabled(), u.getRoles());
        }

        public TestUser(String name, String email, String password, Role role, Role... roles) {
            this(null, name, email, password, true, EnumSet.of(role, roles));
        }

        public TestUser(Integer id, String name, String email, String password, boolean enabled, Set<Role> roles) {
            super(id, name, email, password, enabled, roles);
        }

        public User asUser() {
            return new User(this);
        }

        @Override
        public String toString() {
            return "User (" +
                    "id=" + id +
                    ", email=" + email +
                    ", name=" + name +
                    ", enabled=" + enabled +
//                    ", password=" + password +
                    ", authorities=" + roles +
                    ')';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            TestUser that = (TestUser) o;
            return /*Objects.equals(this.password, that.password)
                    &&*/ Objects.equals(this.id, that.id)
                    && Objects.equals(this.name, that.name)
                    && Objects.equals(this.email, that.email)
                    && Objects.equals(this.enabled, that.enabled)
                    && Objects.equals(this.roles, that.roles);
        }
    }

    private static boolean comparePassword(String rawPassword, String password) {
        if (PasswordUtil.isEncoded(rawPassword)) {
            LOG.warn("Expected password couldn't be compared with actual");
        } else if (!PasswordUtil.isMatch(rawPassword, password)) {
            LOG.error("Password " + password + " doesn't match encoded " + password);
            return false;
        }
        return true;
    }
}
