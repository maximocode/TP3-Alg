import java.util.ArrayList;

public class Universidad{
    private String nombre;
    private String direccion;
    private ArrayList<Estudiante> estudiantes;

    public Universidad(){
        this.estudiantes=new ArrayList<Estudiante>();
    }
    public Universidad(String nombre, String direccion){
        this.nombre=nombre;
        this.direccion=direccion;
        this.estudiantes=new ArrayList<Estudiante>();
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    public ArrayList<Estudiante> getEstudiantes(){
      return estudiantes;
    }
    public void setEstudiantes(ArrayList<Estudiante> estudiantes){
     this.estudiantes = estudiantes;
    }    
    
}