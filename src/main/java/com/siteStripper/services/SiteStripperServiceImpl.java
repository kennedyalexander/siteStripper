package com.siteStripper.services;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.siteStripper.models.WebPage;

@Service
public class SiteStripperServiceImpl implements SiteStripperService {

	@Override
	public Elements stripOffImages(Elements elements) {
		// TODO Auto-generated method stub
		
		return elements.select("figure").remove();
	}

	@Override
	public Elements stripOffJS(Elements elements) {
		// TODO Auto-generated method stub
		return elements.select("script").remove();
	}

	@Override
	public String findContent(String url) throws IOException {
		
		return getDocument(url);
	}
	
	public String getDocument(String url) throws IOException{
		Document doc = Jsoup.connect(url).get();
		
		Elements newsHeadlines = new Elements();
		newsHeadlines.add(doc.getElementsByClass("story-body__h1").get(0));
		newsHeadlines.addAll(doc.getElementsByClass("story-body__inner"));
		newsHeadlines = stripOffImages(newsHeadlines);
		newsHeadlines = stripOffJS(newsHeadlines);
		
		
		//newsHeadlines.select("body > div > div.story-body__inner > figure.media-landscape.has-caption.full-width.lead > span");
//		for(Element single : newsHeadlines){
//			
//		}
		
		//newsHeadlines.select("a").remove();
		//doc.select("script").remove();
		//doc.select("figure").remove();
		return newsHeadlines.html();
	}


}
