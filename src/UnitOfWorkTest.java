import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import org.eclipse.persistence.sessions.Session;
import org.eclipse.persistence.sessions.UnitOfWork;
import org.eclipse.persistence.sessions.factories.SessionFactory;
import org.eclipse.persistence.sessions.factories.SessionManager;
import org.eclipse.persistence.sessions.server.Server;

import model.Emp;


public class UnitOfWorkTest {
	public static void main(String[] args) {
		try{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "persistence_unit_name" );
		EntityManager entityManager = emfactory.createEntityManager( );
		Session session = ((EntityManagerImpl) entityManager).getActiveSession();
		entityManager.getTransaction( ).begin( );
		UnitOfWork uow = session.acquireUnitOfWork();
		Emp emp = entityManager.find(Emp.class, 1202);
		uow.registerObject(emp);
		emp.setEname( "first uow" );
		emp.setSalary( 50000 );	
		uow.commit();		
		entityManager.getTransaction( ).commit();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
