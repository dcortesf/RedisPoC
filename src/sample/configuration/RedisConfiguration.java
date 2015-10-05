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
	public JedisConnectionFactory jedisConnection(){
		
		JedisConnectionFactory conFactory = new JedisConnectionFactory();
		conFactory.setHostName(env.getProperty("redishost"));
		//conFactory.setPort(6379);
		conFactory.setPort(Integer.parseInt(env.getProperty("redisport")));
		
		
		return conFactory;	
	}
	
	@Bean
	public RedisHttpSessionConfig getSessionConfig(){
		
		RedisHttpSessionConfig sessionConfig = new RedisHttpSessionConfig();
		return sessionConfig;
	}

}
