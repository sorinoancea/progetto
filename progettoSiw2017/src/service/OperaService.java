package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import persistence.OperaCrudRepository;
import model.Opera;
//dovra delegare le operazioni ad un crud repository funzionante
public class OperaService {
	private EntityManager em;

	public Opera insertProduct(Opera p) {	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("museo-unit");
		this.em = emf.createEntityManager();
		OperaCrudRepository pr = new OperaCrudRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		//		em.persist(opera);
		pr.save(p);
		tx.commit();
		em.close();
		emf.close();
		return p;
	}

	public List<Opera> getAllProducts() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("museo-unit");
		this.em = emf.createEntityManager();
		OperaCrudRepository pr = new OperaCrudRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		//		TypedQuery<Product> query = em.createNamedQuery("findAll", Product.class);
		//		List<Product> products = query.getResultList(); 
		List<Opera> products = pr.findAll();
		tx.commit();
		em.close();
		emf.close();
		return products;
	}

	public Opera getOneProduct(Long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("museo-unit");
		this.em = emf.createEntityManager();
		OperaCrudRepository pr = new ProductRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		//		Product p = em.find(Product.class, id);
		Opera p = pr.findOne(id);
		tx.commit();
		em.close();
		emf.close();
		return p;
	}
	
	public void deleteOpera(Opera p) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("museo-unit");
		this.em = emf.createEntityManager();
		OperaCrudRepository pr = new OperaCrudRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		//		em.remove(em.contains(p) ? p : em.merge(p));
		pr.delete(p);
		tx.commit();
		em.close();
		emf.close();
	}
}