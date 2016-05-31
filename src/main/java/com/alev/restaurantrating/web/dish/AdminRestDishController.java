package com.alev.restaurantrating.web.dish;

import com.alev.restaurantrating.model.Dish;
import com.alev.restaurantrating.web.ExceptionInfoHandler;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(AdminRestDishController.REST_URL)
public class AdminRestDishController extends AbstractDishController implements ExceptionInfoHandler {
    public static final String REST_URL = "/rest/admin/restaurants/{restaurantId}/menus/{menuId}/dishes";

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Dish get(@PathVariable("id") int id, @PathVariable int menuId, @PathVariable int restaurantId) {
        //ToDo checkRestaurant(int menuId, int restaurantId);
        return super.get(id, menuId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id, @PathVariable int menuId, @PathVariable int restaurantId) {
        super.delete(id, menuId);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Dish> getAll(@PathVariable int menuId) {
        return new ArrayList<>(super.getAll(menuId));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Dish menu, @PathVariable("id") int id, @PathVariable int menuId, @PathVariable int restaurantId) {
        super.update(menu, id, menuId);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> createWithLocation(@RequestBody Dish menu, @PathVariable int menuId, @PathVariable int restaurantId) {
        Dish created = super.create(menu, menuId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(restaurantId, menuId, created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}
