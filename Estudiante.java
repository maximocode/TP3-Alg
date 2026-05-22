import java.util.ArrayList;

public class Estudiante extends Persona{
    private Carrera carrera;
    private float promedio;
    private ArrayList<Materia> materias;

    public Estudiante(){
        super();
        this.materias=new ArrayList<Materia>();
    }
    public Estudiante(String apellido, String nombre, int edad, String documento, Carrera carrera, float promedio){
        super(apellido, nombre, edad, documento);
        this.carrera=carrera;
        this.promedio=promedio;
        this.materias=new ArrayList<Materia>();
    }
    public Carrera getCarrera(){ 
        return carrera;
    }
    public void setCarrera(Carrera carrera){
        this.carrera=carrera;
    }
    public Float getPromedio(){
        return promedio;
    }
    public void setPromedio(float promedio){
        if(promedio>=0 && promedio<=10){
            this.promedio=promedio;
        } 
    }
    public float calcularPromedio(){
      if(materias.isEmpty()){
         return 0;
        }
      float suma = 0;
      for(Materia m : materias){
         suma += m.getNota();
        }
      this.promedio = suma / materias.size();
      return this.promedio;
    }

    public ArrayList<Materia> getMaterias(){
        return materias;
    }
    public void setMaterias(ArrayList<Materia> materias){
        this.materias=materias;
    }

    public void agregarMaterias(Materia materia){
        this.materias.add(materia);
    }

    public String toString(){
        return super.toString()+", Carrera: "+carrera+", Promedio: "+promedio+", Materias: "+materias;
    }
    public void equals(Estudiante estudiante){
        if(this.getDocumento().equals(estudiante.getDocumento())){
            System.out.println("Los estudiantes son iguales");
        }else{
            System.out.println("Los estudiantes son diferentes");
        }
    }
    public int hashCode(){
        return getDocumento().hashCode();
    }

    /*public String obtenerRol(){
        return "Estudiante";
    }
    public String infoCompleta(){
        return "Carrera: " + getCarrera() + "Promedio: " + getPromedio() + "Matrerias: " + getMaterias();
    }*/
}
