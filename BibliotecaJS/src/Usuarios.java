
public class Usuarios {
	
	public String nombre, tipo;

	public Usuarios(String nombre, String tipo) {
		this.nombre = nombre;
		
		if(tipo.equals("0")) {
			this.tipo = "Bibliotecario";
		}
		else if(tipo.equals("1")) {
				this.tipo = "Administrador";
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
