package com.zzg.cartitem.PoVo;

import java.math.BigDecimal;

import com.zzg.domain.Book;
import com.zzg.domain.CartItem;
import com.zzg.domain.User;

public class CartitemPoVo extends CartItem{
	private Book book;
	private User user;
	private double subTotal;
	
	public double getSubTotal() {
		BigDecimal  count  = new BigDecimal(this.getQuantity()) ;
		
		subTotal = book.getCurrprice().multiply(count).doubleValue();
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "CartitemPoVo [book=" + book + ", user=" + user + ", subTotal=" + subTotal + "]";
	}	
}
