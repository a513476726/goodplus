package com.zzg.book.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.zzg.domain.Book;
import com.zzg.domain.CartItem;

public interface IBookService {


	List<Book> getbooksService(String cid,Integer pageNum);

	List<Book> selectbyauthorService(String author);

	List<Book> selectbypressService(String press);

	List<Book> selectbybnameService(String bname);

	Book selectbybidService(String bid);

	List<Book> selebygaojiService(Book book);

	CartItem addcartitemService(HttpSession session,String bid, Integer quantity);
}
