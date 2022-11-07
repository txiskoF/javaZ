package net.zabalburu.actividad12.app;

import javax.security.auth.login.AppConfigurationEntry;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.zabalburu.actividad12.modelo.ModeloBBDD;

public class App {

	public App() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.registerBean(CacheConfig.class);
		ctx.refresh();
		ctx.refresh();
		ModeloBBDD modelo =(ModeloBBDD) ctx.getBean("modeloBBDD");
		ctx.close();
	}

}
