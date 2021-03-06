import java.util.ArrayList;
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
		List<Emp> lst=new ArrayList<Emp>();
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "persistence_unit_name" );
		EntityManager entityManager = emfactory.createEntityManager( );
		Session session = ((EntityManagerImpl) entityManager).getActiveSession();
		entityManager.getTransaction( ).begin( );
		UnitOfWork uow = session.acquireUnitOfWork();
		Emp emp = entityManager.find(Emp.class, 1202);
		emp.setEname( "3333333333333333333333" );
		emp.setSalary( 50000 );	
		
		Emp emp1 = entityManager.find(Emp.class, 1203);
		emp1.setEname( "4444444444444444" );
		emp1.setEid(1);
		emp1.setSalary( 50000 );	
		lst.add(emp);
		lst.add(emp1);
		uow.registerAllObjects(lst);
		uow.commit();		
		entityManager.getTransaction( ).commit();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
