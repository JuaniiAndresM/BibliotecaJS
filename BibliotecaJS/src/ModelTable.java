
public class ModelTable {
	
	static String codigo, titulo, autor, tipo;

	public ModelTable(String codigo, String titulo, String autor, String tipo) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.tipo = tipo;
	}

	public static String getCodigo() {
		return codigo;
	}

	public static void setCodigo(String codigo) {
		ModelTable.codigo = codigo;
	}

	public static String getTitulo() {
		return titulo;
	}

	public static void setTitulo(String titulo) {
		ModelTable.titulo = titulo;
	}

	public static String getAutor() {
		return autor;
	}

	public static void setAutor(String autor) {
		ModelTable.autor = autor;
	}
	public static String getTipo() {
		return tipo;
	}
	public static void setTipo(String tipo) {
		ModelTable.tipo = tipo;
	}
}
