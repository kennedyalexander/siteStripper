package com.siteStripper.services;

import java.io.IOException;
import java.util.List;

import org.jsoup.select.Elements;

import com.siteStripper.models.WebPage;

public interface SiteStripperService {

	Elements stripOffImages(Elements elements);
	Elements stripOffJS(Elements elements);
	String
	findContent(String url) throws IOException;
	
}
