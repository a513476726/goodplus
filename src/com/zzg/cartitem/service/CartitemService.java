package com.zzg.cartitem.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.zzg.cartitem.PoVo.CartitemPoVo;
import com.zzg.domain.User;

public interface CartitemService {

	List<CartitemPoVo> GetCartitemsService(String uid);

	User deletecartitembycartitemidService(String cartitemid, HttpSession session, Model model);

	void updatequantityService(String cartitemid, Integer quantity, Double currprice);

	void deletecartitemsService(String[] ids, HttpSession session, Model model);

}
