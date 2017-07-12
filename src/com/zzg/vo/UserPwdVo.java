package com.zzg.vo;

import com.zzg.domain.User;

public class UserPwdVo  extends  User {
	
	private   String  newpass ;

	public String getNewpass() {
		return newpass;
	}

	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}

	@Override
	public String toString() {
		return "UserPwdVo [newpass=" + newpass + ", toString()="
				+ super.toString() + "]";
	}
	
}
