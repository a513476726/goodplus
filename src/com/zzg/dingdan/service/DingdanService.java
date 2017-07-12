package com.zzg.dingdan.service;

import java.util.List;

import com.zzg.dingdan.povo.DingdanPovo;
import com.zzg.domain.Dingdan;

public interface DingdanService {

	

	List<DingdanPovo> getDingdans(String uid);

	void addDingdan(String[] ids, Dingdan dingdan);


	DingdanPovo selectbyoidService(String oid);

	void affirmService(String oid);

	void cancelService(String oid);

}
