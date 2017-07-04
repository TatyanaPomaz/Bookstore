package bookstore.dao;

import bookstore.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderDAOImpl implements OrderDAO {
    private static final Logger logger = LoggerFactory.getLogger(BookDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addOrder(Order order) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(order);
        logger.info("Order successfully saved. Order details: " + order);
    }

    @Override
    public void updateOrder(Order order) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(order);
        logger.info("Order successfully updated. Order details: " + order);
    }

    @Override
    public void removeOrder(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Order order = (Order) currentSession.load(Order.class, new Long(id));

        if (order != null) {
            currentSession.delete(order);
        }
        logger.info("Order successfully removed. Order details: " + order);
    }

    @Override
    public Order getOrderById(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Order order = (Order) currentSession.load(Order.class, new Long(id));
        logger.info("Order successfully loaded. Order details: " + order);

        return order;
    }
}
