package com.calisma.OnlineSinav;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class SinavGirisController {
	DB db=new DB();
	static String  id;
	static String soruy;
	ResultSet rs;
	@RequestMapping(value="/soruListele",method=RequestMethod.POST)
public String soruListele(Model model) {
		List<SoruPro> sorux = new ArrayList<SoruPro>();
		
		String q = "select * from soru";
		
		try {
			rs = db.baglan().executeQuery(q);
			while (rs.next()) {
				SoruPro sp4 = new SoruPro();
				sp4.setId(rs.getString(1));
				sp4.setSoru(rs.getString(2));
				
				
				
				sorux.add(sp4);//sorular listeye eklendi

			

	}
			model.addAttribute("sorux", sorux);	
		} catch (SQLException e) {
			
		
		}
		return "SinavSayfasi";
}
	@RequestMapping(value="/soruCevapla/{soruId}",method=RequestMethod.POST)
public String soruCevapla(Model model,@PathVariable String soruId) {
		System.out.println(soruId);
		id=soruId;
		List<SoruPro> sorux = new ArrayList<SoruPro>();
		
		String q = "SELECT secenek\n" + 
		
				"FROM secenek\n" + 
				"INNER JOIN soru ON secenek.soruid= soru.ID where soruid='"+soruId+"';";
		ResultSet rs;
		try {
			rs = db.baglan().executeQuery(q);
			while (rs.next()) {
				SoruPro sp1 = new SoruPro();
				sp1.setSecenek(rs.getString("secenek"));
				

				sorux.add(sp1);//secenekler  listeye eklendi



	}
			model.addAttribute("sorux", sorux);
		} catch (SQLException e) {
			
		
		}
		String query = "SELECT soru\n" + 
				
				"FROM soru\n" + 
				"where ID='"+id+"';";
		ResultSet rss;
		
		try {
			rss = db.baglan().executeQuery(query);
			while (rss.next()) {
				SoruPro sp1 = new SoruPro();
				 soruy=rss.getString("soru");
				

				



	}
			System.out.println("soruy"+soruy);
			model.addAttribute("soruy", soruy);
		} catch (SQLException e) {
			
		
		}
		
		return "YanitSayfasi";
}
	@RequestMapping(value= "/secenekDogrula/{secenek}",method=RequestMethod.POST)
	public String secenekDogrula(Model model,@PathVariable String secenek) {
			System.out.println(secenek);
			
			
			
			String q = "SELECT durum\n" + 
			
					"FROM secenek\n" + 
					" where secenek='"+secenek+"';";
			ResultSet rs = null;
			try {
				SoruPro sp1 = new SoruPro();
		
				rs = db.baglan().executeQuery(q);
				while (rs.next()) {
				
					if(rs.getString("durum").equals("1")) {
						model.addAttribute("Sonuc", "Dogru Bildiniz");
					}
					else {
						model.addAttribute("Sonuc", "Bilemediniz");
					}
					
					
			}
				rs.close();
				db.kapat();

			} catch (SQLException e) {
				
			
			}

		
			
			try {
			System.out.println("Durum"+rs.getString("durum"));
			System.out.println("id"+rs.getString("id"));
				Statement st = db.baglan();
				int yazz = st.executeUpdate("insert into cevap values(null,'" + rs.getString("durum") + "','" +id+ "')");
				
			} catch (SQLException e) {
				
			System.out.println("yazma hatasi"+e);
			}
			
			return "Cevap";
	}
}
