import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Emp;


public class UnitOfWorkTest {
	public static void main(String[] args) {
		try{
		EntityManagerFactory emfactory = Persistence.
				createEntityManagerFactory( "EclipseLink" );
				EntityManager entitymanager = emfactory.
				createEntityManager( );
				
				
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
