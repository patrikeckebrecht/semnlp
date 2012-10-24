/**
 * 
 */
package model;

import java.util.LinkedList;
import java.util.List;

/**
 * @author muelleml
 *
 */
public class Corpus {
	
	//System.lineSeparator() requires jre 7
	private String del = System.getProperty("line.separator");
	
	public List<Sentence> sentences;
	String Name;
	
	public Corpus() {
		 sentences = new LinkedList<Sentence>();
	}
	
	public String toString(){
		
		// TODO determine optimal Size for initialization
		StringBuilder r= new StringBuilder();
		
		for (Sentence s : sentences){
			// using lineSeperator may or may not be a good idea
			r.append(s.toString() + del);
		}
		
		return r.toString();
		
	}

}