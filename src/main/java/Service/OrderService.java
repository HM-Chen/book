package Service;

import Pojo.Cart;

public interface OrderService{
    public String createOrder(Cart cart, Integer userId);
}
