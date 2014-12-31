import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.databind.ObjectMapper;

@EntityScan
@EnableAutoConfiguration
public class SpringHibernateJackson {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(). //
				sources(SpringHibernateJackson.class). //
				run(args);
		ObjectMapper objectMapper = context.getBean("objectMapper", ObjectMapper.class);
		Test test = new Test();
		test.setId(1L);
		test.setAttribute("attribute");
		System.out.println(test);
		String json = objectMapper.writeValueAsString(test);
		System.out.println(json);
		test = objectMapper.readValue(json, Test.class);
		System.out.println(test);
		context.close();
	}

}
