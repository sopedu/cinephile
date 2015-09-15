package com.muca.cinephile;

import java.io.IOException;

import com.rometools.rome.io.FeedException;

public class Deneme {

	
  public static void main(String[] args) throws IllegalArgumentException, IOException, FeedException {
	MynetExtractor mynetExtractor = new MynetExtractor();
	mynetExtractor.fillComingSoon("http://sinema.mynet.com/rss/RSS-gelecekprogram/rss.xml");
}
}
