package sample.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import sample.RedisHttpSessionConfig;

@Configuration
public class RedisConfiguration {
	@Autowired
	Environment env;
	
	@Bean
	public JedisConnectionFactory jedisConnection(@Value("${redishost}") String host){
		
		System.out.println(env.getProperty("redishost"));
		
		JedisConnectionFactory conFactory = new JedisConnectionFactory();
		conFactory.setHostName(host);
		conFactory.setPort(6379);
		
		
		return conFactory;	
	}
	
	@Bean
	public RedisHttpSessionConfig getSessionConfig(){
		
		RedisHttpSessionConfig sessionConfig = new RedisHttpSessionConfig();
		return sessionConfig;
	}

}
