package com.alev.restaurantrating.service;


import com.alev.restaurantrating.repository.JpaUtil;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

abstract public class AbstractJpaUserServiceTest extends AbstractUserServiceTest {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private JpaUtil jpaUtil;

    @After
    public void tearDown() throws Exception {
        super.tearDown();
        jpaUtil.clear2ndLevelHibernateCache();
    }
}