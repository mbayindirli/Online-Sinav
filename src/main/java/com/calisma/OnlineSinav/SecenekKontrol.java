package com.calisma.OnlineSinav;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecenekKontrol {
	
	DB db=new DB();
	
	static String id="";
	 static String soru="";
	@RequestMapping(value = "/SecenekKontrol/{soruId}", method = RequestMethod.POST)
	public String soruSil(@PathVariable String soruId, Model model) {
		
		id=soruId;
		try {
			String q = "select soru from soru where id='"+soruId+"'";

			
			ResultSet rs = db.baglan().executeQuery(q);
		
			while (rs.next()) {
				
			soru=rs.getString("soru");
			

				
			}
		
			model.addAttribute("soru", soru);
			

		} catch (Exception e) {
			System.out.println("Yazma Hatasi" + e);
		}
		return "SecenekEkle";
	}
	@RequestMapping(value = "/secenekEkle", method = RequestMethod.POST)
	public String secenekEkle(Model model,SoruPro sp) {

		
		try {
			
			
				Statement st = db.baglan();
		String durum="";
		if(sp.getDurum().equals("Dogru")) {
	durum="1";		
	}
		else {
			durum="0";
		}
           
				int yaz = st.executeUpdate("insert into secenek values(null,'" + id + "','" +durum+ "','"+sp.getSecenek()+"')");

				List<SoruPro> liste = new ArrayList<SoruPro>();
				System.out.println(id);
				
				
				String q = "select id,secenek,durum from secenek where soruid='"+id+"'";
				ResultSet rs = db.baglan().executeQuery(q);
				while (rs.next()) {
					SoruPro sp1 = new SoruPro();
					sp1.setSecenek(rs.getString("secenek"));
					sp1.setId(rs.getString("id"));
					durum=rs.getString("durum");
					if(durum.equals("1")) {
						durum="dogru";
					}
					else {
						durum="yanlis";
					}
					sp1.setDurum(rs.getString("durum"));
					System.out.println(sp.getSecenek());

					liste.add(sp1);
				}
				model.addAttribute("liste", liste);
				model.addAttribute("soru", soru);
		
		} catch (Exception e) {
			System.out.println("Yazma Hatasi" + e);
		}
		
		
		
		
		return "SecenekEkle";
	}
	@RequestMapping(value = "/secenekSil/{secenek}", method = RequestMethod.POST)
	public String secenekSil(@PathVariable String secenek, Model model) {
		System.out.println("soru sonucu " + secenek);
		try {
		
				Statement st = db.baglan();

				int yaz = st.executeUpdate("delete from secenek where secenek='" + secenek + "'");
				if (yaz > 0) {
					List<SoruPro> liste = new ArrayList<SoruPro>();
					SoruPro sp1 = new SoruPro();
					String q = "select id,secenek from secenek where soruid='"+id+"'";
					ResultSet rs = db.baglan().executeQuery(q);
					while (rs.next()) {
					
						sp1.setSecenek(rs.getString("secenek"));
						sp1.setId(rs.getString("id"));

						liste.add(sp1);

					}
					model.addAttribute("liste", liste);
					model.addAttribute("soru", soru);
				}
	

		} catch (Exception e) {
			System.out.println("Yazma Hatasi" + e);
		}
		return "SecenekEkle";
	}
	@RequestMapping(value = "/secenekBitir", method = RequestMethod.GET)
	public String secenekBitir() {
	
		
		return "SinavDuzenle";
	}
	
	}


