package zool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//开启自动配置
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("启动成功");
	}
}
