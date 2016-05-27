package com.alev.restaurantrating.web.dish;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AdminDishController.REST_URL)
public class AdminDishController extends AbstractDishController {
    public static final String REST_URL = "/rest/admin/{restaurantId}/{menuId}/dishes";
}
