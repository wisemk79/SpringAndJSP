package ex.di6;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
	//명시적 의존주입이 없어도 자동주입(byType) 의존주입이 일어난다.
	@Autowired
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
