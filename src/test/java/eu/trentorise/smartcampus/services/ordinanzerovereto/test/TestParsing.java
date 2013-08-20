package eu.trentorise.smartcampus.services.ordinanzerovereto.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import eu.trentorise.smartcampus.services.ordinanzerovereto.impl.Script;

public class TestParsing {

	public static void main(String[] args) throws IOException {
		String line = null;
		
		String txt = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/test/resources/ordinanze.txt")));
		try {
			while ((line = br.readLine()) != null) {
				txt += line+"\n";
			}
			System.err.println(new Script().createOrdinanze(txt));
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			 br.close();
		 }
	}
}
