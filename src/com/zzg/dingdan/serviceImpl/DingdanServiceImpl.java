package com.zzg.dingdan.serviceImpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzg.cartitem.PoVo.CartitemPoVo;
import com.zzg.dao.CartItemMapper;
import com.zzg.dao.DingdanMapper;
import com.zzg.dao.OrderitemMapper;
import com.zzg.dingdan.dao.DingdanDao;
import com.zzg.dingdan.povo.DingdanPovo;
import com.zzg.dingdan.service.DingdanService;
import com.zzg.domain.Dingdan;
import com.zzg.domain.Orderitem;

import uuid.UUIDHelper;

@Service
public class DingdanServiceImpl implements DingdanService {
	@Autowired
	private DingdanMapper dingdanMapper;
	@Autowired
	private CartItemMapper cartitemMapper;
	@Autowired
	private OrderitemMapper orderitemMapper;
	@Autowired
	private DingdanDao dingdanDao;

	public void addDingdan(String[] cartitemids, Dingdan dingdan) {
		dingdanMapper.insert(dingdan);
		dingdanDao.addDingdanDao(cartitemids,dingdan);
	}
	
	public List<DingdanPovo> getDingdans(String uid) {
		List<DingdanPovo> list = dingdanMapper.selectdingdanbyuid(uid);
		System.err.println("************"+list+"***************");
		return list;
	}

	public DingdanPovo selectbyoidService(String oid) {
		return dingdanDao.selectbyoidDao(oid);
	}

	@Override
	public void affirmService(String oid) {
		Map<String,Object>  map = new HashMap<String, Object>();
		map.put("oid", oid);
		map.put("status", 4);
		dingdanMapper.updateStatus(map);
	}

	@Override
	public void cancelService(String oid) {
		Map<String,Object>  map = new HashMap<String, Object>();
		map.put("oid", oid);
		map.put("status", 5);
		dingdanMapper.updateStatus(map);
	}

}
