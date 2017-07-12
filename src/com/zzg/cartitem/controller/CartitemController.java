package com.zzg.cartitem.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzg.cartitem.PoVo.CartitemPoVo;
import com.zzg.cartitem.service.CartitemService;
import com.zzg.dao.CartItemMapper;
import com.zzg.domain.User;

@Controller
public class CartitemController {
	@Autowired
	private CartitemService cartitemService;
	@Autowired
	private CartItemMapper cartitemMapper;

	@RequestMapping(value = "/getcartitems/{uid}")
	public String getCartitems(@PathVariable String uid, Model model) {
		System.out.println("-----66666666666666-----");
		List<CartitemPoVo> cartitems = cartitemService.GetCartitemsService(uid);
		model.addAttribute("cartItems", cartitems);
		System.out.println(cartitems);
		return "jsps/cart/list";
	}

	@RequestMapping(value = "/deletecartitembycartitemid/{cartitemid}")
	public String deletecartitembycartitemid(@PathVariable String cartitemid, HttpSession session, Model model) {
		User user = cartitemService.deletecartitembycartitemidService(cartitemid, session, model);
		String uid = user.getUid();
		return "redirect:/getcartitems/" + uid;
	}

	// 批量删除
	@RequestMapping(value = "/deletecartitems")
	public String deletecartitems(String[] ids, HttpSession session, Model model) {
		cartitemService.deletecartitemsService(ids,session,model);
		User  user = (User)session.getAttribute("user");
		String uid  =user.getUid();
		return "redirect:/getcartitems/" + uid;
	}

	// updatequantity
	@RequestMapping(value = "/updatequantity/{cartitemid}", method = RequestMethod.POST)
	public void updatequantity(@PathVariable String cartitemid, Integer quantity, Double currprice) {
		System.out.println(currprice);
		/* int quantity = cartItem.getQuantity(); */
		System.out.println(quantity + "---------------------------------");
		cartitemService.updatequantityService(cartitemid,quantity,currprice);
	}

	@RequestMapping(value = "/jiesuan/{ids}", method = RequestMethod.POST)
	public String jiesuan(@PathVariable String[] ids, Model model, HttpSession session) {

		System.out.println(Arrays.toString(ids));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", ((User) session.getAttribute("user")).getUid());
		map.put("ids", Arrays.asList(ids));

		List<CartitemPoVo> povos = cartitemMapper.jiesuan(map);
		model.addAttribute("cartitems", povos);
		/*
		 * for (CartItemPoVo cartItemPoVo : povos) {
		 * System.out.println(cartItemPoVo); }
		 */
		return "jsps/cart/showitem";
	}
}
