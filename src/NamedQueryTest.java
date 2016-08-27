import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Emp;


public class NamedQueryTest {
	public static void main(String[] args) {
		try{
		EntityManagerFactory emfactory = Persistence.
				createEntityManagerFactory( "persistence_unit_name" );
				EntityManager entitymanager = emfactory.
				createEntityManager( );
				
				namedQuery(emfactory, entitymanager);
				
		}catch(Exception e){
			System.out.println(e);
		}
	}
	static void namedQuery(EntityManagerFactory emfactory, EntityManager entitymanager){
		entitymanager.getTransaction( ).begin( );
		Query q=entitymanager.createNamedQuery("find emp by id");
		q.setParameter("id", 1);
		List<Emp> empList=q.getResultList();
		System.out.println("----------name :: "+empList.get(0).getEname());
		//entitymanager.getTransaction( ).commit( );
		entitymanager.close( );
		emfactory.close( );
		
	}
	
}
