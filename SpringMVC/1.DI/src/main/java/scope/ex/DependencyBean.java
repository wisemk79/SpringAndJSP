package scope.ex;

public class DependencyBean {
	private InjectionBean injectionBean;
	
	public DependencyBean(InjectionBean injectionBean) {
		System.out.println("DependencyBean: Constructor=> " + injectionBean);
		this.injectionBean = injectionBean;
	}

	public void setInjectionBean(InjectionBean injectionBean) {
		System.out.println("DependencyBean: Setter=> " + injectionBean);
		this.injectionBean = injectionBean;
	}
	
	
}
