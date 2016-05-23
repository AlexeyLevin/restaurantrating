package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.LunchMenu;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

import static com.alev.restaurantrating.ModelTestData.*;
import static com.alev.restaurantrating.Profiles.DATAJPA;
import static org.junit.Assert.assertTrue;

@ActiveProfiles(DATAJPA)
public class MenuServiceImplTest extends AbstractServiceTest {

    @Autowired
    protected MenuService service;

    @Test
    public void testSave() {
        LunchMenu lunchMenu = new LunchMenu(null, "New menu", LocalDate.now());
        LunchMenu created = service.save(lunchMenu, RESTAURANT_1_ID);
        lunchMenu.setId(created.getId());
        MENU_MATCHER.assertCollectionEquals(Arrays.asList(RESTAURANT_1_MENU, created), service.getAll(RESTAURANT_1_ID));
    }

    @Test
    public void testDelete() {
        service.delete(RESTAURANT_1_MENU_ID, RESTAURANT_1_ID);
        assertTrue(service.getAll(RESTAURANT_1_ID).isEmpty());
    }

    @Test
    public void testGet() {
        LunchMenu actual = service.get(RESTAURANT_2_MENU_ID, RESTAURANT_2_ID);
        MENU_MATCHER.assertEquals(RESTAURANT_2_MENU, actual);
    }

    @Test
    public void testGetByName() {
        LunchMenu actual = service.getByName("Ragnarok menu");
        MENU_MATCHER.assertEquals(RESTAURANT_2_MENU, actual);
    }

    @Test
    public void testUpdate() {
        LunchMenu updated = new LunchMenu(RESTAURANT_1_MENU_ID, RESTAURANT_1_NAME + " обновленный", LocalDate.now());
        service.update(updated, RESTAURANT_1_ID);
        MENU_MATCHER.assertEquals(updated, service.get(RESTAURANT_1_MENU_ID, RESTAURANT_1_ID));
    }

    @Test
    public void testGetAll() {
        MENU_MATCHER.assertCollectionEquals(Collections.singleton(RESTAURANT_1_MENU), service.getAll(RESTAURANT_1_ID));
    }
}