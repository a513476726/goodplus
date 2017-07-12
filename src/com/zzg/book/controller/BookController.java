package com.zzg.book.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.zzg.book.service.IBookService;
import com.zzg.domain.Book;
import com.zzg.domain.CartItem;

@Controller
public class BookController {
	@Autowired
	private IBookService bookService;

	@RequestMapping(value="/getbooks/{cid}")
	public String getbooks(@PathVariable String cid,Model model,Integer pageNum) {
		List<Book> books = bookService.getbooksService(cid,pageNum);
		PageInfo<Book> info= new PageInfo<Book>(books);
		model.addAttribute("books", books);
		model.addAttribute("info", info);
		return  "/jsps/book/list";
	}
	@RequestMapping(value = "/selectbyauthor/{author}")
	public String selectbyauthor(@PathVariable String author, Model model) throws Exception{
		author = new String(author.getBytes("iso8859-1"), "utf-8");
		List<Book> books= bookService.selectbyauthorService(author);
		model.addAttribute("books", books);
		return "/jsps/book/list";
	}

	@RequestMapping(value = "/selectbypress")
	public String selectbypress(String press, Model model)throws Exception{
		press = new String(press.getBytes("iso8859-1"),0,press.getBytes("iso8859-1").length, "utf-8");
		List<Book> books=bookService.selectbypressService(press);
		model.addAttribute("books", books);
		return "/jsps/book/list";
	}
	@RequestMapping(value = "/selectbybname")
	public String selectbybname(String bname, Model model)throws Exception{
		bname = new String(bname.getBytes("iso8859-1"),0,bname.getBytes("iso8859-1").length, "utf-8");
		List<Book> books = bookService.selectbybnameService(bname);
		model.addAttribute("books", books);
		return "/jsps/book/list";
	}
	@RequestMapping(value = "/selectbygaoji")
	public String selectbygaoji(Book book, Model model)throws Exception{
		List<Book> books = bookService.selebygaojiService(book);
		model.addAttribute("books", books);
		return "/jsps/book/list";
	}

	@RequestMapping(value = "/selectbybid/{bid}")
	public String selectbybid(@PathVariable  String  bid, Model model)
			throws UnsupportedEncodingException {
		Book book = bookService.selectbybidService(bid);
		model.addAttribute("book",book);
		return "/jsps/book/desc";
	}
	@RequestMapping(value = "/addcartitem/{bid}")
	public String addcartitem(@PathVariable  String  bid, HttpSession session,Model model,Integer quantity)
			throws UnsupportedEncodingException {
		CartItem cartItem = bookService.addcartitemService(session,bid,quantity);
		String uid= cartItem.getUid();
		model.addAttribute("book","");
		return  "redirect:/getcartitems/"+uid;
	}
}
