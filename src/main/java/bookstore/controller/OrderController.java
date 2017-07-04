package bookstore.controller;

import bookstore.model.Order;
import bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {
    private OrderService orderService;

    @Autowired(required = true)
    @Qualifier(value = "orderService")
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "orders/{userId}", method = RequestMethod.GET)
    public String getListOfOrders(@PathVariable("userId") long userId, Model model) {
        model.addAttribute("book", new Order());
        model.addAttribute("listOrders", orderService.getAllOrdersByUserId(userId));

        return "orders";
    }

    @RequestMapping(value = "/orders/add", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("order") Order order) {
        if (order.getId() == 0) {
            orderService.addOrder(order);
        } else {
            orderService.updateOrder(order);
        }

        return "redirect:/orders";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") long id) {
        orderService.removeOrder(id);

        return "redirect:/orders";
    }

    @RequestMapping("/{userId}/edit/{id}")
    public String editOrder(@PathVariable("id") long id, @PathVariable("userId") long userId, Model model) {
        model.addAttribute("order", orderService.getOrderById(id));
        model.addAttribute("listOrders", orderService.getAllOrdersByUserId(userId));

        return "orders";
    }

    @RequestMapping("orderdata/{id}")
    public String orderData(@PathVariable("id") long id, Model model) {
        model.addAttribute("order", orderService.getOrderById(id));

        return "orderdata";
    }

}
