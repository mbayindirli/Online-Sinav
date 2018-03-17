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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SinavDuzenleController {
	
	DB db=new DB();
	


	@RequestMapping(value = "/soruekle", method = RequestMethod.POST)
	public String soruekle(@RequestParam(defaultValue = "") String soru, Model model) {
		try {
			System.out.println(soru);
			if (soru.length() > 0) {
				Statement st = db.baglan();

				int yaz = st.executeUpdate("insert into soru values(null,'" + soru + "')");

				List<SoruPro> ls = new ArrayList<SoruPro>();
				
				String q = "select id,soru from soru";
				ResultSet rs = db.baglan().executeQuery(q);
				while (rs.next()) {
					SoruPro sp = new SoruPro();
					sp.setSoru(rs.getString("soru"));
					sp.setId(rs.getString("id"));

					ls.add(sp);
				}
				model.addAttribute("ls", ls);
			}
		} catch (Exception e) {
			System.out.println("Yazma Hatasi" + e);
		}
		return "SinavDuzenle";
	}
	@RequestMapping(value = "/soruSil/{soruId}", method = RequestMethod.GET)
	public String soruSil(@PathVariable String soruId, Model model) {
		System.out.println("soru sonucu " + soruId);
		try {
			if (soruId.length() > 0) {
				Statement st = db.baglan();

				int yaz = st.executeUpdate("delete from soru where ID='" + soruId + "'");
				if (yaz > 0) {
					List<SoruPro> ls = new ArrayList<SoruPro>();
					String q = "select id,soru from soru";
					ResultSet rs = db.baglan().executeQuery(q);
					while (rs.next()) {
						SoruPro sp = new SoruPro();
						sp.setSoru(rs.getString("soru"));
						sp.setId(rs.getString("ID"));

						ls.add(sp);

					}
					model.addAttribute("ls", ls);
				}
			}

		} catch (Exception e) {
			System.out.println("Yazma Hatasi" + e);
		}
		return "SinavDuzenle";
	}

	
	
}