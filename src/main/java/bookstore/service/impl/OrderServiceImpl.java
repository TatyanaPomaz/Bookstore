package bookstore.service.impl;

import bookstore.dao.OrderDAO;
import bookstore.model.Order;
import bookstore.model.User;
import bookstore.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO;

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public void addOrder(Order order) {
        orderDAO.addOrder(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderDAO.updateOrder(order);
    }

    @Override
    public void removeOrder(long id) {
        orderDAO.removeOrder(id);
    }

    @Override
    public Order getOrderById(long id) {
        return orderDAO.getOrderById(id);
    }

    @Override
    public List<Order> getAllOrdersByUserId(long userId) {
        return orderDAO.getAllOrdersByUserId(userId);
    }
}
