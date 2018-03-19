package com.HibernateMapping.DemoMapping;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
    	
    	
    	Laptop laptop= new Laptop();
		laptop.setId(104);
		laptop.setLname("lenovo");
		
		Student st  = new Student();
		st.setMarks(50);
		st.setRollno(2);
		st.setName("geethu");
	     st.getLaptop().add(laptop);
		//st.setLaptop(laptop);
		
	     
	     laptop.getStudent().add(st);
	     
	   
		Configuration conf = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		
		
		SessionFactory ssf  = conf.buildSessionFactory(reg);
		
		Session sess  = ssf.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		sess.save(laptop);
		
		sess.save(st);
		
		sess.getTransaction().commit();
		
		
		System.out.println("Test");
		
		
	/*	Configuration con  = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);	        

			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();	        
	    
			SessionFactory sf  =  con.buildSessionFactory(reg);	    	
			
	    	Session  sess1 = sf.openSession(); 		    	
	    	
	    	Transaction tx = sess1.beginTransaction();
	    	
	    	sess1.save(laptop);
	    	sess1.save(st);
	    	
	    	sess1.getTransaction().commit();*/

    	
       // System.out.println( "Hello World!" );
    }
}


/*select * from neon.alien_table;

use neon;
show tables;
select * from laptop;
select * from student;
select * from laptop_student;

use neon;
drop tables laptop; 

use neon;
drop tables student;

drop tables student_laptop;
drop tables laptop_student;



SET FOREIGN_KEY_CHECKS=0;

DROP TABLE laptop;
 
 
DROP TABLE  student;

SET FOREIGN_KEY_CHECKS=0;



*/