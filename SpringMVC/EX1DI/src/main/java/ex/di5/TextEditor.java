package ex.di5;

public class TextEditor {
	private SpellChecker spellChecker;
	private String name;
	
	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}
	
	public void spellCheck(){
		spellChecker.checkSpelling();
	}
}
