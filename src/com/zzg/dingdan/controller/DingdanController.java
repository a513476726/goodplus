package com.zzg.dingdan.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.AlipayConfig;
import com.zzg.dao.DingdanMapper;
import com.zzg.dingdan.povo.DingdanPovo;
import com.zzg.dingdan.service.DingdanService;
import com.zzg.domain.Dingdan;

import uuid.UUIDHelper;

@Controller
public class DingdanController {
	
	@Autowired
	private DingdanService dingdanService;
	@Autowired
	private DingdanMapper dingdanMapper;
	
	@RequestMapping(value="/makedingdan" , method=RequestMethod.POST)
	public String  makedingdan(@RequestParam("ids")  String[] ids,Model model, Dingdan dingdan){
		
		dingdan.setOid(UUIDHelper.getUUID());
		Date date =  new Date();
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

		dingdan.setOrdertime(sdf.format(date));
		dingdan.setStatus(1);
		dingdanService.addDingdan(ids,dingdan);
		model.addAttribute("dingdan", dingdan);
		return  "jsps/order/ordersucc";
	}
	
	@RequestMapping(value="/getdingdans/{uid}" , method=RequestMethod.GET)
	public String  getdingdans(@PathVariable String uid,Model model){
			List<DingdanPovo>   dingdans =  dingdanService.getDingdans(uid);
			model.addAttribute("dingdans", dingdans);
			return  "jsps/order/list";
	}
	
	@RequestMapping(value = "/getdingdan/{oid}", method = RequestMethod.GET)
	public String getdingdan(@PathVariable String oid, Model model) {
		DingdanPovo dingdan =dingdanService.selectbyoidService(oid);
		model.addAttribute("dingdan", dingdan);
		return    "jsps/order/desc";
	}
	//  affirm
	@RequestMapping(value = "/affirm/{oid}", method = RequestMethod.GET)
	public String affirm(@PathVariable String oid, Model model) {
		dingdanService.affirmService(oid);
		model.addAttribute("code", "success");
		model.addAttribute("msg", "订单已确认，购物愉快");
		return    "jsps/msg";
	}
	//  cancel
	@RequestMapping(value = "/cancel/{oid}", method = RequestMethod.GET)
	public String cancel(@PathVariable String oid, Model model) {
		dingdanService.cancelService(oid);
		model.addAttribute("code", "success");
		model.addAttribute("msg", "订单已取消，购物不愉快");
		return    "jsps/msg";
	}
	
	//payying
		@RequestMapping(value = "/payying/{oid}", method = RequestMethod.GET)
		public String payying(@PathVariable String oid, Model model) {
			Dingdan   dingdan  =dingdanMapper.selectByPrimaryKey(oid);
			model.addAttribute("dingdan", dingdan);
			return    "jsps/order/pay";
	}
		
	@SuppressWarnings("unused")
	@RequestMapping(value = "/pay/{oid}", method = RequestMethod.GET)
	public void pay(@PathVariable String oid, Model model,HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		Dingdan dingdan = dingdanMapper.selectByPrimaryKey(oid);
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		//alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		
		//商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = dingdan.getOid();
		//付款金额，必填
		String total_amount = dingdan.getTotal().toString();
		//订单名称，必填
		String subject = "购买图书";
		//商品描述，可空
		String body = "商品描述--->";
		
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		//请求
		String result = alipayClient.pageExecute(alipayRequest).getBody();
		//输出
		response.getWriter().print(result);
		
	}
	@RequestMapping(value = "/returnurl", method = RequestMethod.GET)
	public String cancel(Model model,HttpServletRequest  request) throws Exception {
		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		@SuppressWarnings("unchecked")
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		//
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
		
		//——请在这里编写您的程序（以下代码仅作参考）——
		if(signVerified) {
			//
			String oid = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			Dingdan  dingdan  =dingdanMapper.selectByPrimaryKey(oid);
			dingdan.setStatus(2);
			dingdanMapper.updateByPrimaryKey(dingdan);
			model.addAttribute("code", "success");
			model.addAttribute("msg", "支付成功，将为您尽快安排发货！");
			
		}else {
			//
			model.addAttribute("code", "error");
			model.addAttribute("msg", "支付失败，请重新支付！");
		}
		
		return    "jsps/msg";
	}
}
