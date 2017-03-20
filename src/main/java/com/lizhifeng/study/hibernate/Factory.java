package com.lizhifeng.study.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

public class Factory{
	private static SessionFactory sf =new Configuration().configure().buildSessionFactory();	
	
	public static void save(Object obj){
		Session session = null ;
		try{
			session = sf.openSession();
			session.beginTransaction();			
			session.save(obj);
			session.getTransaction().commit();
		}catch(HibernateException e){
			e.printStackTrace();
			System.out.println("事务执行失败！！！！");
			session.getTransaction().rollback();
		}finally{
            if(session != null){  
                if(session.isOpen()){  
                    session.close();  
                }  
            }  
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public static List<Object> select(String query_sql,String... args)
	{
		List<Object> result = null ;
		Session session = null;

		try{
			session = sf.openSession();
			Query query = session.createQuery(query_sql);			
			result = query.list();
		}catch(HibernateException e){
			//Log.log(e.toString());
			//e.printStackTrace();
		}finally{
            if(session != null){  
                if(session.isOpen()){  
                    session.close();  
                }  
            }  
		}		
		return result ;
	}
	
	public static void del(Object obj)
	{
		Session session = null ;
		try{
			session = sf.openSession();
			session.beginTransaction();			
			session.delete(obj);
			session.getTransaction().commit();
		}catch(HibernateException e){
			e.printStackTrace();			
			session.getTransaction().rollback();
		}finally{
            if(session != null){  
                if(session.isOpen()){  
                    session.close();  
                }  
            }  
		}
	}
}

