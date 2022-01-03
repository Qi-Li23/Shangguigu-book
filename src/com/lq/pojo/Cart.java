package com.lq.pojo;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车
 * @author qili
 * @create 2022-01-03-15:04
 */
public class Cart {
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    /**
     * 添加商品项
     * @param item
     */
    public void addItem(CartItem item) {
        //判断购物车中是否有该商品项
        //如果有，则修改该商品项的数量和总金额
        CartItem cartItem = items.get(item.getId());
        if(cartItem == null) {
            //没有添加过该商品项
            items.put(item.getId(), item);
        } else {
            //添加过该商品项
            //修改数量
            cartItem.setCount(cartItem.getCount() + 1);
            //修改总金额
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }

    /**
     * 删除商品项
     * @param id
     */
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clearCart() {
        items.clear();
    }

    /**
     * 修改商品数量
     * @param id
     * @param count
     */
    public void updateCount(Integer id, Integer count) {
        CartItem cartItem = items.get(id);
        if(cartItem != null) {
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        Collection<CartItem> cartItems = items.values();
        for (CartItem cartItem : cartItems) {
            totalCount += cartItem.getCount();
        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        Collection<CartItem> cartItems = items.values();
        for (CartItem cartItem : cartItems) {
            totalPrice = totalPrice.add(cartItem.getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
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
