package persistencia.entidad;

/**@author rubenor*/
public class Cliente implements Almacenable{
    protected String nombre;
    protected String apellidos;
    protected String telefono;
    protected String email;

    public Cliente(String nombre, String apellidos, String telefono, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String toStringCsv(){
        return nombre+";"+apellidos+";"+telefono+";"+email+"\n";
    }

    /** Funcion que determina a nivel de valor si dos objetos
     * cliente tienen los mismos valores en sus atributos */
    public boolean equals(Cliente c){
        if(
            c.nombre.equals(this.nombre) &&
            c.apellidos.equals(this.apellidos) &&
            c.telefono.equals(this.telefono) &&
            c.email.equals(this.email)
        )
            return true;
        else
            return false;
    }
}
