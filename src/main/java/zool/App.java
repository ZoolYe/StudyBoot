package zool;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableCaching//开启缓存支持
@EnableTransactionManagement//开启声明式事物支持
@SpringBootApplication//开启自动配置
@MapperScan(basePackages = {"zool.domain.dao"})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("<<<<<<<<<<<<<<<<<< 智能引擎启动成功 >>>>>>>>>>>>>>>>>");
	}
}
