package ex.di6;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String configLocation = "classpath:Bean.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		TextEditor txe = ctx.getBean("textEditor", TextEditor.class);
		
		txe.spellCheck();
	}

}
