package jp.co.internous.wings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.wings.model.domain.MstProduct;
import jp.co.internous.wings.model.mapper.MstProductMapper;
import jp.co.internous.wings.model.session.LoginSession;

@Controller
@RequestMapping("/wings/product")
public class ProductController {
	
	@Autowired
	private MstProductMapper mstProductMapper;
	
	@Autowired 
	private LoginSession loginSession;

	@RequestMapping("/{id}")
	public String index(@PathVariable("id") int id,Model m) {
		MstProduct mstProduct = mstProductMapper.findById(id);
	
		m.addAttribute("mstProduct",mstProduct);
		m.addAttribute("loginSession",loginSession);
		
		return "product_detail";
	}
}
