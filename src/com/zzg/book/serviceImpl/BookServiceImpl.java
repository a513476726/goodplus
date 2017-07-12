package com.zzg.book.serviceImpl;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.zzg.book.dao.BookMapperImpl;
import com.zzg.book.service.IBookService;
import com.zzg.domain.Book;
import com.zzg.domain.CartItem;


@Service
public class BookServiceImpl implements IBookService{

	@Autowired
	private BookMapperImpl bookMapperImpl;
	
	@Override
	public List<Book> getbooksService(String cid,Integer pageNum) {
		return bookMapperImpl.getbooksDao(cid,pageNum);
	}

	@Override
	public List<Book> selectbyauthorService(String author) {
		// TODO Auto-generated method stub
		return bookMapperImpl.selectbyauthorDao(author);
	}

	@Override
	public List<Book> selectbypressService(String press) {
		// TODO Auto-generated method stub
		return bookMapperImpl.selectbypressDao(press);
	}

	@Override
	public List<Book> selectbybnameService(String bname) {
		
		return bookMapperImpl.selectbybnameDao(bname);
		 
	}

	@Override
	public Book selectbybidService(String bid) {
		return bookMapperImpl.selectbybidDao(bid);
	}

	@Override
	public List<Book> selebygaojiService(Book book) {
		return bookMapperImpl.selebygaojiDao(book);
	}

	@Override
	public CartItem addcartitemService(HttpSession session,String bid,Integer quantity) {
		return bookMapperImpl.addcartitemDao(session,bid,quantity);
		
	}
	
}