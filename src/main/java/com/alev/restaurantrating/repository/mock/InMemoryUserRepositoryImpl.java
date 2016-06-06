package com.alev.restaurantrating.repository.mock;

import com.alev.restaurantrating.model.User;
import com.alev.restaurantrating.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryUserRepositoryImpl implements UserRepository {
    private static final Logger LOG = LoggerFactory.getLogger(InMemoryUserRepositoryImpl.class);

    private Map<Integer, User> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    public static final Comparator<User> USER_COMPARATOR = Comparator.comparing(User::getName);

    @Override
    public User save(User user) {
        Assert.notNull(user, "user must not be null");
        if (user.isNew()) {
            user.setId(counter.incrementAndGet());
        }
        repository.put(user.getId(), user);
        return user;
    }

    @PostConstruct
    public void postConstruct() {
        LOG.info("+++ PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        LOG.info("+++ PreDestroy");
    }

    @Override
    public boolean deleting(Integer id) {
        return repository.remove(id) != null;
    }

    @Override
    public User get(Integer id) {
        return repository.get(id);
    }

    @Override
    public User findByName(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public User getWithFields(Integer integer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> getAll() {
        return repository.values().stream().sorted(USER_COMPARATOR).collect(Collectors.toList());
    }

    @Override
    public User getByEmail(String email) {
        Assert.notNull(email, "email must not be null");
        return repository.values().stream().filter(u -> email.equals(u.getEmail())).findFirst().orElse(null);
    }
}
