package com.alev.restaurantrating.web.dish;

import com.alev.restaurantrating.model.Dish;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(AdminRestDishController.REST_URL)
public class AdminRestDishController extends AbstractDishController {
    public static final String REST_URL = "/rest/admin/restaurants/menus/{menuId}/dishes";

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Dish get(@PathVariable("id") int id, @PathVariable int menuId) {
        return super.get(id, menuId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id, @PathVariable int menuId) {
        super.delete(id, menuId);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Dish> getAll(@PathVariable int menuId) {
        return new ArrayList<>(super.getAll(menuId));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Dish menu, @PathVariable("id") int id, @PathVariable int menuId) {
        super.update(menu, id, menuId);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> createWithLocation(@RequestBody Dish menu, @PathVariable int menuId) {
        Dish created = super.create(menu, menuId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(menuId, created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}
