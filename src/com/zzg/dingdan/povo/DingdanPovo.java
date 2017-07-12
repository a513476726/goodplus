package com.zzg.dingdan.povo;

import java.util.List;

import com.zzg.domain.Dingdan;
import com.zzg.domain.Orderitem;

public class DingdanPovo  extends Dingdan{

	private  List<Orderitem>   orderitems ;

	

	@Override
	public String toString() {
		return "DingdanPovo [orderitems=" + orderitems + ", toString()="
				+ super.toString() + "]";
	}

	public List<Orderitem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}
	
}
