package Pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {

//    public Integer totalCount;
//    public BigDecimal totalPrice;

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public Map<Integer,CartItem> getItems(){
        return items;
    }

    private Map<Integer,CartItem> items = new LinkedHashMap<Integer,CartItem>();

    public void addItem(CartItem cartItem)
    {
        CartItem item = items.get(cartItem.getId());
        if(item == null) {
            items.put(cartItem.getId(),cartItem);
        }
        else {
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }

    }

    public void deleteItem(Integer id)
    {
        items.remove(id);
    }

    public void clear()
    {
        items.clear();
    }

    public void updateCount(Integer id,Integer count)
    {
        CartItem cartItem = items.get(id);
        if(cartItem != null) {
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for(Map.Entry<Integer,CartItem>entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }



    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);

        for(Map.Entry<Integer,CartItem>entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }



    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
