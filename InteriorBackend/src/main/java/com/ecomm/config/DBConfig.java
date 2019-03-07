package com.ecomm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecomm.model.CartItem;
import com.ecomm.model.Category;
import com.ecomm.model.OrderDetail;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;
import com.ecomm.model.UserDetail;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecomm")
public class DBConfig {
 
	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/project_1");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		System.out.println("---DataSource Object is Created---");
		
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.hbm2ddl.auto","update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder factory = new LocalSessionFactoryBuilder(getH2DataSource());
		factory.addProperties(hibernateProp);
		
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(Product.class);
		factory.addAnnotatedClass(Supplier.class);
		factory.addAnnotatedClass(UserDetail.class);
		factory.addAnnotatedClass(CartItem.class);
		factory.addAnnotatedClass(OrderDetail.class);
		
		System.out.println("---SessionFactory object is Created---");
		
		return factory.buildSessionFactory();
	}
	
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("---Transaction Manager Object is Created---");
		return new HibernateTransactionManager(sessionFactory);
	}
	
}
