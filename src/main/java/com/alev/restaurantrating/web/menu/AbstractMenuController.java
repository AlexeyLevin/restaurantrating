package com.alev.restaurantrating.web.menu;


import com.alev.restaurantrating.model.Menu;
import com.alev.restaurantrating.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class AbstractMenuController {
    private final Logger LOG = LoggerFactory.getLogger(AbstractMenuController.class);

    @Autowired
    private MenuService menuService;

    public Menu get(int id, int restaurantId) {
        LOG.info("get menu {} for Restaurant {}", id, restaurantId);
        return menuService.get(id, restaurantId);
    }

    public void delete(int id, int restaurantId) {
        LOG.info("delete menu {} for Restaurant {}", id, restaurantId);
        menuService.delete(id, restaurantId);
    }

    public Collection<Menu> getAll(int restaurantId) {
        LOG.info("getAll for Restaurant {}", restaurantId);
        return menuService.getAll(restaurantId);
    }

    public void update(Menu menu, int id, int restaurantId) {
        menu.setId(id);
        LOG.info("update {} for Restaurant {}", menu, restaurantId);
        menuService.update(menu, restaurantId);
    }

    public Menu create(Menu menu, int restaurantId) {
        menu.setId(null);
        LOG.info("create {} for Restaurant {}", menu, restaurantId);
        return menuService.save(menu, restaurantId);
    }
}
