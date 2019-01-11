package com.mtx.api.v1;

import com.mtx.domain.Order;
import com.mtx.domain.User;
import com.mtx.repository.OrderRepository;
import com.mtx.repository.UserRepository;
import com.mtx.service.OrderService;
import com.mtx.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value = {"/api/orders","/api/order"})
public class OrderController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Order> getOrderList() {
        logger.debug("list orders");
        return new ArrayList<>();
    }

    @RequestMapping(value="/{Id}", method = RequestMethod.GET)
    public Order findById(@PathVariable("Id") Long id){
        logger.debug("this order id is:"+id);
        return orderService.findById(id);
    }

    @RequestMapping(value="/user/{id}",method = RequestMethod.POST)
    public Order generatorOrder(@RequestBody Order order, @PathVariable("id") Long userId) {
        logger.debug("user id" +userId);
        order.setNewDate(LocalDate.now());
        User user = userService.findById(userId);
        order.setUser(user);
        return orderService.save(order);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"orderDate"})
    public List<Order>getUsersByOrderDate(@RequestParam(value="orderDate") Instant orderDate){
        logger.debug("parameter name is" + orderDate);
        List<Order> order = orderService.findByOrderDate(orderDate);
        return order;
    }

}
