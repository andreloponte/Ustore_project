package desafio.ustore.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import desafio.ustore.objetos.Usuario;

public class RepositorioUsuario {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioUsuario(){
		emf = Persistence.createEntityManagerFactory("desafio");
		em = emf.createEntityManager();
	}

	public void salvar(Usuario usuario){
		em.getTransaction().begin();
		em.merge(usuario);		
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remover(Usuario usuario){
		em.getTransaction().begin();
		em.remove(usuario);		
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select usuario from Usuario usuario");
		List<Usuario> usuarios = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return usuarios;
	}
	
}
