import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Emp;


public class CrudTest {
	public static void main(String[] args) {
		try{
		EntityManagerFactory emfactory = Persistence.
				createEntityManagerFactory( "persistence_unit_name" );
				EntityManager entitymanager = emfactory.
				createEntityManager( );
				
				add(emfactory, entitymanager);
				
				//update(emfactory, entitymanager);
				
				//delete(emfactory,entitymanager);
				
		}catch(Exception e){
			System.out.println(e);
		}
	}
	static void add(EntityManagerFactory emfactory, EntityManager entitymanager){
		entitymanager.getTransaction( ).begin( );
		Emp emp = new Emp( );
		//emp.setEid( 1203 );
		emp.setEname( "Jaggiqqqq" );
		emp.setSalary( 50000 );				
		entitymanager.persist( emp );
		entitymanager.getTransaction( ).commit( );
		entitymanager.close( );
		emfactory.close( );
		
	}
	
	static void update(EntityManagerFactory emfactory, EntityManager entitymanager){
		entitymanager.getTransaction( ).begin( );
		Emp emp = entitymanager.find(Emp.class, 1201);
		emp.setEname( "Golu" );
		//entitymanager.persist( emp );
		entitymanager.getTransaction( ).commit( );
		entitymanager.close( );
		emfactory.close( );
		
	}
	
	static void delete(EntityManagerFactory emfactory, EntityManager entitymanager){
		entitymanager.getTransaction( ).begin( );
		Emp emp = entitymanager.find(Emp.class, 1202);
		entitymanager.remove( emp );
		entitymanager.getTransaction( ).commit( );
		entitymanager.close( );
		emfactory.close( );
		
	}

}
