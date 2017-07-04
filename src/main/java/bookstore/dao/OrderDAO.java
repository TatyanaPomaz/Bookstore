package bookstore.dao;

import bookstore.model.Order;

public interface OrderDAO {
    void addOrder(Order order);

    void updateOrder(Order order);

    void removeOrder(long id);

    Order getOrderById(long id);
}
