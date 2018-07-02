package be.vdab;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Persoon {

	private final Set<String> voornamen;
	
	public Persoon(String... voornamen) {
		//Parameter cannot be null
		//LinkedHashSet keeps order of items and cannot contain similar elements
		if(voornamen != null  && checkVoornamen(voornamen)) {
			this.voornamen = new LinkedHashSet<String> (Arrays.asList(voornamen));
		}else {
			throw new IllegalArgumentException("Foute voornamen!!!");
		}
	}
	
	public Set<String> getVoornamen() {
		return voornamen;
	}
	
	private boolean checkVoornamen(String...voornamen) {
		//Een persoon moet minstens één voornaam hebben
		if(voornamen.length == 0) {
			return false;
		}
		//Een voornaam mag niet null zijn en
		//moet minstens één niet-blanco teken bevatten
		for(String vn: voornamen) {
			if(vn == null || vn.equals(" ") || vn.isEmpty())  {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder names = new StringBuilder();
		for ( Iterator<String> n = this.voornamen.iterator(); n.hasNext(); ) {
			names.append(n.next());
			if(n.hasNext()) {
				names.append(" ");
			}
		}
		return names.toString();
	}
}
