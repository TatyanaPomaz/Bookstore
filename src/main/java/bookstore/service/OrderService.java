package bookstore.service;

import bookstore.model.Order;
import bookstore.model.User;

import java.util.List;

public interface OrderService {
    void addOrder(Order order);

    void updateOrder(Order order);

    void removeOrder(long id);

    Order getOrderById(long id);

    List<Order> getAllOrdersByUserId(long userId);
}
