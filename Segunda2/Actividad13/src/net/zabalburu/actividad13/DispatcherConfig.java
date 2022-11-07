package net.zabalburu.actividad13;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
public class DispatcherConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		Class[] clases = { AppConfig.class };
		return clases;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	

}
