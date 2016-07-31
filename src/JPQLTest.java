import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Emp;


public class JPQLTest {
	public static void main(String[] args) {
		try{
		EntityManagerFactory emfactory = Persistence.
				createEntityManagerFactory( "EclipseLink" );
				EntityManager entitymanager = emfactory.
				createEntityManager( );
				
				
				select(emfactory, entitymanager);
				
				
		}catch(Exception e){
			System.out.println(e);
		}
	}
	static void select(EntityManagerFactory emfactory, EntityManager entitymanager){
		//entitymanager.getTransaction( ).begin( );
	
		Query upperSelect=entitymanager.createQuery("select UPPER(e.empName) from Emp e");
		System.out.println("Upper name : "+upperSelect.getResultList());
		
		Query maxSelect=entitymanager.createQuery("select MAX(e.empSalary) from Emp e");
		System.out.println("Max Salary : "+maxSelect.getSingleResult());
		
		
		Query betweenSelect=entitymanager.createQuery("select e from Emp e where e.empSalary between 35000 and 45000");
		List<Emp> empList = (List<Emp>)betweenSelect.getResultList();
		System.out.println("between select name : "+empList.get(0).getEname());
		
		Query likeSelect=entitymanager.createQuery("select e from Emp e where e.empName like 'J%'");
		List<Emp> empLikeList = (List<Emp>)likeSelect.getResultList();
		System.out.println("like select name : "+empLikeList.get(0).getEname());
		
		
		Query query = entitymanager.
				createQuery( "Select e " +
				"from Emp e " +
				"ORDER BY e.empName DESC" );
				List<Emp> list=(List<Emp>)query.getResultList( );
				for( Emp e:list )
				{
				System.out.print("Employee ID :"+e.getEid( ));
				System.out.println("\t Employee Name :"+e.getEname( ));
				}
				
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
