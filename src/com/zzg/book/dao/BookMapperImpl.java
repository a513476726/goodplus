package com.zzg.book.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzg.dao.BookMapper;
import com.zzg.dao.CartItemMapper;
import com.zzg.domain.Book;
import com.zzg.domain.BookExample;
import com.zzg.domain.BookExample.Criteria;
import com.zzg.domain.CartItem;
import com.zzg.domain.CartItemExample;
import com.zzg.domain.User;

import uuid.UUIDHelper;

@Repository
public class BookMapperImpl {
	@Autowired
	private BookMapper bookMapper;
	@Autowired
	private CartItemMapper cartitemMapper;

	public List<Book> getbooksDao(String cid, Integer pageNum) {
		BookExample example = new BookExample();
		example.createCriteria().andCidEqualTo(cid);
		PageHelper.startPage(pageNum, 8);
		List<Book> books = bookMapper.selectByExample(example);
		return books;
	}

	public List<Book> selectbyauthorDao(String author) {
		BookExample example = new BookExample();
		example.createCriteria().andAuthorEqualTo(author);
		List<Book> books = bookMapper.selectByExample(example);
		return books;
	}

	public List<Book> selectbypressDao(String press) {
		BookExample example = new BookExample();
		example.createCriteria().andPressEqualTo(press);
		List<Book> books = bookMapper.selectByExample(example);
		return books;
	}

	public List<Book> selectbybnameDao(String bname) {
		BookExample example = new BookExample();
		example.createCriteria().andBnameLike("%" + bname + "%");
		List<Book> books = bookMapper.selectByExample(example);
		return books;
	}

	public Book selectbybidDao(String bid) {
		Book book = bookMapper.selectByPrimaryKey(bid);
		return book;
	}

	public List<Book> selebygaojiDao(Book book) {
		BookExample example = new BookExample();
		Criteria criteria = example.createCriteria();
		System.out.println(book + "------------------------------------------");
		if (!book.getAuthor().equals("")) {

			criteria.andAuthorLike("%" + book.getAuthor() + "%");
		}
		if (!book.getBname().equals("")) {
			criteria.andBnameLike("%" + book.getBname() + "%");
		}
		if (!book.getPress().equals("")) {
			criteria.andPressLike("%" + book.getPress() + "%");
		}
		List<Book> books = bookMapper.selectByExample(example);
		return books;
	}

	public CartItem addcartitemDao(HttpSession session, String bid, Integer quantity) {
		CartItem cartItem = new CartItem();
		String cartitemid = UUIDHelper.getUUID();
		cartItem.setQuantity(quantity);
		cartItem.setBid(bid);
		cartItem.setCartitemid(cartitemid);
		User u = (User) session.getAttribute("user");
		cartItem.setUid(u.getUid());
		CartItemExample example = new CartItemExample();
		example.createCriteria().andUidEqualTo(u.getUid()).andBidEqualTo(bid);
		List<CartItem> list = cartitemMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			cartitemMapper.insert(cartItem);
		} else {
			list.get(0).setQuantity(quantity + list.get(0).getQuantity());
			cartitemMapper.updateByPrimaryKey(list.get(0));
		}
		return cartItem;

	}

}
