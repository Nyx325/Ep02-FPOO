package persistencia.entidad;

/**@author rubenor*/
public class Empleado extends Cliente {
    protected String departamento;
    protected String cargo;

    public Empleado(String nombre, String apellidos, String telefono, String email, String departamento, String cargo) {
        // Llamar al constructor de cliente para instanciar empleado
        super(nombre, apellidos, telefono, email);
        this.departamento = departamento;
        this.cargo = cargo;
    }
    
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toStringCsv(){
        return nombre+";"+apellidos+";"+telefono+";"+email+";"+departamento+";"+cargo+"\n";
    }
}
