package com.TechCarrerApi.Controllers;




import java.util.List;


import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.TechCarrerApi.Models.Categories;
import com.TechCarrerApi.Models.Products;

@Controller
public class HomeController {

	
	@GetMapping("/Products")
	public String MyPage() {
			
		// Web Api'den Spring Boot Kütüphanesini kullanarak DATA ÇEKME.
		RestTemplate template = new RestTemplate();
		ResponseEntity<List> response =  template.getForEntity("http://localhost:2606/api/Products", List.class);		
		List<Products> products = response.getBody();

		
		// API'e Object Post etme.	
		Categories kategori = new Categories();
		kategori.Description = "MVC tarafından gönderildi Description";
		kategori.Keyword  = "MVC tarafından gönderildi Keyword";
		kategori.Status = true;
		kategori.Submenu = 0;
		kategori.Name = "Oto Tamir";
	    // POST edilecek olan nesne yukarıda dolduruluyor, aşağıda ise ne tür bir yapı gideceğini belirtiyoruz.
		HttpEntity<Categories> requestCategories = new HttpEntity<Categories>(kategori);
		String CategoriesResponse = template.postForObject("http://localhost:2606/api/Categories", requestCategories, String.class);


		//Kategori Listesini API'dan çekiyoruz.
		ResponseEntity<List> response2 =  template.getForEntity("http://localhost:2606/api/Categories", List.class);		
		List<Categories> categories = response2.getBody();
		return "home";
	}
	
	@GetMapping("/Urunler")
	 public String  Urunler(Model model) 
	{
		RestTemplate template = new RestTemplate();
		ResponseEntity<List> response2 =  template.getForEntity("http://localhost:2606/api/Categories", List.class);		
		List<Categories> categories = response2.getBody();
		
		model.addAttribute("kategori",categories);
		
		return "urunler";
	}

	
	
	
}
