package ejercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Nota:  En la consigna se especifica Date (java 7) como tipo de dato
 * para el campo fechaNacimiento. Las líneas comentadas responden a ese
 * requisito, pero la implementación actual utiliza LocalDate (java 8),
 * que es un formato más apropiado.
 */

public class Persona {

    private TipoDocumento tipoDocumento;
    private Integer nroDocumento;
    private String nombre;
    private String apellido;
    //private Date fechaNacimiento;
    private LocalDate fechaNacimiento;

    public Persona(TipoDocumento tipoDocumento,
                   Integer nroDocumento,
                   String nombre,
                   String apellido,
                   //Date fechaNacimiento) {
                   LocalDate fechaNacimiento) {
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public TipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getNroDocumento() {
        return this.nroDocumento;
    }

    public void setNroDocumento(Integer nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

//    public String getFechaNacimiento() {
//        return new SimpleDateFormat("DD/MM//YYYY").format(this.fechaNacimiento);
//
//    }

     public String getFechaNacimiento() {
        return this.fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    }

//    public void setFechaNacimiento(Date fechaNacimiento) {
//        this.fechaNacimiento = fechaNacimiento;
//    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}