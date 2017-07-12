package com.zzg.cartitem.dao;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.zzg.dao.CartItemMapper;
import com.zzg.domain.CartItem;
import com.zzg.domain.User;



@Repository
public class CartitemMapperImpl {

	@Autowired
	private CartItemMapper cartItemMapper;
	
	public void updatequantityDao(String cartitemid, Integer quantity, Double currprice) {
		CartItem cartItem2 = cartItemMapper.selectByPrimaryKey(cartitemid);
		cartItem2.setQuantity(quantity);
		cartItemMapper.updateByPrimaryKey(cartItem2);
	}
	
	
}
