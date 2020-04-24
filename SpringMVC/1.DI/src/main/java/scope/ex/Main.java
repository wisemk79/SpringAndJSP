package scope.ex;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		InjectionBean injectionBean =
				ctx.getBean("injectionBean" , InjectionBean.class);
		
		DependencyBean dependencyBean01 =
				ctx.getBean("dependencyBean" , DependencyBean.class);
		
		DependencyBean dependencyBean02 =
				ctx.getBean("dependencyBean" , DependencyBean.class);
		
//		만약 getBean 객체를 가져올때마다 새로운 객체를 생성하고싶다면 xml에서 prototype으로 scope를 설정해주면된다. 
		//그렇게되면 객체가2번 생성되기 떄문에 컨스트럭터와 세터가 2번호출된다.
		
		
		if(dependencyBean01.equals(dependencyBean02)) {
			System.out.println("dependencyBean01 == dependencyBean02");
		}else {
			System.out.println("dependencyBean01 != dependencyBean02");
		}
		
		ctx.close();
		
	}

}
