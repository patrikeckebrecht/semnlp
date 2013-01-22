/**
 * 
 */
package model;

import java.util.LinkedList;

/**
 * @author muelleml
 * 
 */
public class Word {

	final static String del = "\t";

	public String origin;
	public String sentenceID;
	public String tokenID;
	public String word;
	public String lemma;
	public String pos;
	public String parseTree;
	public LinkedList<Cue> cues = new LinkedList<Cue>();
	public Node node;

	public Word() {
	}

	public Word(String origin, String sentenceID, String tokenID, String word,
			String lemma, String pos, String parseTree) {
		this.origin = origin;
		this.sentenceID = sentenceID;
		this.tokenID = tokenID;
		this.word = word;
		this.lemma = lemma;
		this.pos = pos;
		this.parseTree = parseTree;
	}

	@Override
	public String toString() {
		String appendix;

		if (cues.isEmpty()) {
			appendix = "***";
		} 
		else {
			StringBuilder sb = new StringBuilder(100);
			for (Cue c : cues) {
				sb.append(c.toString());
			}

			appendix = sb.toString();
		}

		String r = origin + del + sentenceID + del + tokenID + del + word + del
				+ lemma + del + pos + del + parseTree + del + appendix;

		return r.trim();
	}

}
