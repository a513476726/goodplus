package com.zzg.cartitem.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.zzg.cartitem.PoVo.CartitemPoVo;
import com.zzg.cartitem.dao.CartitemMapperImpl;
import com.zzg.cartitem.service.CartitemService;
import com.zzg.dao.CartItemMapper;
import com.zzg.domain.User;

@Service
public class CartitemServiceImpl implements CartitemService {
	@Autowired
	private CartItemMapper cartitemMapper;

	@Autowired
	private CartitemMapperImpl cartitemMapperImpl;

	@Override
	public List<CartitemPoVo> GetCartitemsService(String uid) {
		List<CartitemPoVo> cartitems = cartitemMapper.SelectCartitemsPoVoByUid(uid);
		return cartitems;
	}

	@Override
	public User deletecartitembycartitemidService(String cartitemid, HttpSession session, Model model) {
		cartitemMapper.deleteByPrimaryKey(cartitemid);
		User user = (User) session.getAttribute("user");
		return user;
	}

	public void updatequantityService(String cartitemid, Integer quantity, Double currprice) {
		cartitemMapperImpl.updatequantityDao(cartitemid, quantity, currprice);

	}

	@Override
	public void deletecartitemsService(String[] ids, HttpSession session, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", ids);
		cartitemMapper.delete2(map);
	}

}
