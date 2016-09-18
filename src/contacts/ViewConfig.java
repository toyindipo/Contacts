package contacts;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
//import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.AbstractConfigurableTemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
public class ViewConfig {
	
	 @Bean
	  public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
	    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	    viewResolver.setTemplateEngine(templateEngine);
	    return viewResolver;
	  }
	  @Bean
	  public SpringTemplateEngine templateEngine(
			  AbstractConfigurableTemplateResolver templateResolver) {
	    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		//templateEngine.addDialect(new SpringSecurityDialect());
		return templateEngine;
	  }

	
	@Bean
	  public AbstractConfigurableTemplateResolver templateResolver() {
		AbstractConfigurableTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
	    templateResolver.setPrefix("/WEB-INF/views/");
	    templateResolver.setSuffix(".html");
	    templateResolver.setTemplateMode("HTML5");
	    return templateResolver;
	  }
	@Autowired
	  private ServletContext servletContext;
}
