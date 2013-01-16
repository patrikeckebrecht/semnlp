package features.scope;

import java.util.LinkedList;
import java.util.List;

import model.Cue;
import model.Node;
import model.Sentence;
import model.Word;

public class POSSequence implements ScopeFeature {

	@Override
	public ScopeFeatureValue extractTrain(Sentence s) {
		ScopeFeatureValue value = new ScopeFeatureValue();
		String[] recentScope = null;
		for(Word w : s.words) {
			if(recentScope == null) {
				recentScope = new String[w.cues.size()];
				for(int i=0; i<recentScope.length; i++) recentScope[i] = "_";
			}
			String label = null;
			int i = 0;
			for(Cue cue : w.cues) {
				if(cue.scope != "_") 
				{
					if(recentScope[i] == "_") {
						label = "B";
					}
					else label = "I";
					break;
				}

				recentScope[i] = cue.scope;
				i++;
			}
			if(label == null)label = "O";
			value.labels.add(label);
		}
		value.features = extractClassif(s);
		return value;
	}

	@Override
	public List<List<String>> extractClassif(Sentence s) {
		List<List<String>> value = new LinkedList<List<String>>();
		for(Word w : s.words) {
			LinkedList<String> list = new LinkedList<String>();
			Node mother = w.node.mother;
			if(mother.mother != null) {
				mother = mother.mother;
			}
			for(Node d1 : mother.daughters) {
				list.add(d1.pos);
				for(Node d2 : d1.daughters) {
					list.add(d2.pos);
				}
			}
			value.add(list);
		}
		return value;
	}
}