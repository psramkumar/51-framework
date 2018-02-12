package configs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.guice.module.SpringModule;

public class SpringConfigModule extends SpringModule {

    public SpringConfigModule() {
        super(new AnnotationConfigApplicationContext(AppConfig.class));
    }
}
