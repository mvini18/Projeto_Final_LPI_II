	package br.uniube.dao;

	import java.util.List;

	import org.hibernate.Criteria;
	import org.hibernate.Query;
	import org.hibernate.Session;
	import org.hibernate.Transaction;
	import org.hibernate.criterion.Example;
	import org.hibernate.criterion.Expression;

	import br.uniube.model.Usuario;
/**
 * Classe de acesso ao banco de dados
 * 
 */
public class UsuarioDAO extends AcessoBancoDAO {


	/**
	 * Classe de acesso ao banco de dados
	 * 
	 */
		private Session session;
		
		public void conecta() {
			session = new HibernateFactory().getSession();
		}
		public void desconecta() throws Exception{
			if (this.session != null)
				this.session.close();
		}
		public void salva (Usuario c) throws Exception{
			conecta();
			Transaction tx = session.beginTransaction();
			try {
				this.session.save(c);
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				throw new Exception("Erro ao registrar um usuário. Descrição:" + e.getMessage());
			} finally {
				desconecta();
			}
		}
		public void salvaOuEdita (Usuario c) throws Exception{
			conecta();
			Transaction tx = session.beginTransaction();
			try {
				
				this.session.saveOrUpdate(c);
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				throw new Exception("Erro ao cadastrar um cinema. Descrição:" + e.getMessage());
			} finally {
				desconecta();
			}
		}
		public void remove (Usuario c) throws Exception{
			conecta();
			Transaction tx = session.beginTransaction();
			try {
				this.session.delete(c);
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				throw new Exception("Erro ao excluir um assento. Descrição:" + e.getMessage());
			} finally {
				desconecta();
			}
		}
		public void atualiza(Usuario c) throws Exception{
			conecta();
			Transaction tx = session.beginTransaction();
			try {
				this.session.update(c);
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				throw new Exception("Erro ao atualizar um cinema. Descrição:" + e.getMessage());
			} finally {
				desconecta();
			}
		}
	    
		public boolean loginUsuario(String email, String senha) throws Exception {

			conecta();
			Transaction transaction = session.beginTransaction();
			Usuario usuario = null;
			try {
				// start a transaction
				transaction = session.beginTransaction();
				// get an user object
				usuario = (Usuario) session.createQuery("FROM tb_login WHERE email = :email").setParameter("email", email)
						.uniqueResult();
				
				if(usuario != null && usuario.getSenha().equals(senha)) {
					return true;
				}
				// commit transaction
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
			desconecta();
			return false;
		}
		
		public List buscaPeloExemplo(Usuario objUsuario) throws Exception {
			conecta();
			Criteria crit = session.createCriteria(Usuario.class);
	        crit.add(Example.create(objUsuario));
	        List resultado = crit.list();
	        desconecta();
	        return resultado;
		}
		public List pesquisar(Usuario objUsuario) throws Exception {
			conecta();
			Criteria crit = session.createCriteria(Usuario.class);
			if (objUsuario.getEmail() != null && !objUsuario.getEmail().equals(""))
				crit.add(Expression.like("email",objUsuario.getEmail() + "%"));
			List resultado = crit.list();
			desconecta();
			return resultado;
		}
		public List buscaUsuarios() throws Exception{
			conecta();
			List lista = this.session.createQuery("from br.uniube.model.Usuario").list();
			desconecta();
			return lista;
		}
		
		
	 // fim da classe UsuarioDAO


}
