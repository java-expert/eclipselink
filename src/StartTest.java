import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Emp;


public class StartTest {
	public static void main(String[] args) {
		try{
		EntityManagerFactory emfactory = Persistence.
				createEntityManagerFactory( "EclipseLink" );
				EntityManager entitymanager = emfactory.
				createEntityManager( );
				entitymanager.getTransaction( ).begin( );
				Emp emp = new Emp( );
				emp.setEid( 1202 );
				emp.setEname( "Gopal" );
				emp.setSalary( 40000 );				
				entitymanager.persist( emp );
				entitymanager.getTransaction( ).commit( );
				entitymanager.close( );
				emfactory.close( );
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
