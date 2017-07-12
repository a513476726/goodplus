package com.zzg.dingdan.dao;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zzg.cartitem.PoVo.CartitemPoVo;
import com.zzg.dao.CartItemMapper;
import com.zzg.dao.DingdanMapper;
import com.zzg.dao.OrderitemMapper;
import com.zzg.dingdan.povo.DingdanPovo;
import com.zzg.domain.Dingdan;
import com.zzg.domain.Orderitem;

import uuid.UUIDHelper;

@Repository
public class DingdanDao {
	@Autowired
	private DingdanMapper dingdanMapper ;
	@Autowired
	private CartItemMapper cartitemMapper;
	@Autowired
	private OrderitemMapper orderitemMapper;

	public  DingdanPovo selectbyoidDao(String oid) {
			DingdanPovo dingdan = dingdanMapper.selectbyoid(oid);
			return dingdan;
		}
	
	public void addDingdanDao(String[] cartitemids, Dingdan dingdan) {
		for (String cartitemid : cartitemids) {
			Orderitem orderitem = new Orderitem();
			CartitemPoVo povo = cartitemMapper.selectCartItemPoVoByCartitemid(cartitemid);
			cartitemMapper.deleteByPrimaryKey(cartitemid);
			orderitem.setBid(povo.getBid());
			orderitem.setBname(povo.getBook().getBname());
			orderitem.setCurrprice(povo.getBook().getCurrprice());
			orderitem.setImageB(povo.getBook().getImageB());
			orderitem.setOid(dingdan.getOid());
			orderitem.setOrderitemid(UUIDHelper.getUUID());
			orderitem.setQuantity(povo.getQuantity());
			orderitem.setSubtotal(new BigDecimal(povo.getSubTotal()));
			orderitemMapper.insert(orderitem);
		}
	}
	
	}

