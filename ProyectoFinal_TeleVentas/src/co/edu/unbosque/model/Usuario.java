package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;
import org.apache.commons.codec.digest.DigestUtils;

@Entity
@Table(name="usuario")
@ManagedBean
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	private int id;
	private String usuario;
	private String contraseña;
	private String entidadbancaria;
	private String fechatarjeta;
	private String nombrereal;
	private int codigoseguridad;
	
	public Usuario() {
		
	}
	//--------------------Getters y Setters--------------------//
	
	public String getFechatarjeta() {
		return fechatarjeta;
	}

	public int getCodigoseguridad() {
		return codigoseguridad;
	}

	public void setCodigoseguridad(int codigoseguridad) {
		this.codigoseguridad = codigoseguridad;
	}

	public void setFechatarjeta(String fechatarjeta) {
		this.fechatarjeta = fechatarjeta;
	}

	public String getNombrereal() {
		return nombrereal;
	}

	public void setNombrereal(String nombrereal) {
		this.nombrereal = nombrereal;
	}

		
	public String getEntidadbancaria() {
		return entidadbancaria;
	}

	public void setEntidadbancaria(String entidadbancaria) {
		this.entidadbancaria = entidadbancaria;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
		
	//--------------------------Métodos---------------------------//
		
	
	/**
	 * Este metodo encripta la contraseña por el metodo MD5
	 * @return retorna la contraseña encriptada
	 */
	public String encriptarMD5(){
		
		String contraEncrip = DigestUtils.md5Hex(contraseña);
		return contraEncrip;
	}
	
	/**
	 * Este metodo encripta la contraseña por el metodo SHA1
	 * @return retorna la contraseña encriptada
	 */
	public String encriptarSHA1(){
		
		String contraEncrip = DigestUtils.sha1Hex(contraseña);
		return contraEncrip;
	}
	
	
	public String registro() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProyectoFinal_TeleVentas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
			
		Usuario u= new Usuario();
		
		// Guarda los datos ingresados en LoginUsuario a la base de datos
		u.setUsuario(usuario);
		u.setContraseña(contraseña);
		
		entityManager.getTransaction().begin();
		entityManager.persist(u);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
			
		return null;
		
	}
		
}