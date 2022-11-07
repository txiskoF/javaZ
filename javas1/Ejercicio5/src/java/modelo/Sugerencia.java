/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ichueca
 */
public class Sugerencia {
    private String nombre;
    private String email;
    private String[] destinatario;
    private String sugerencia;

    public Sugerencia() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String[] destinatario) {
        this.destinatario = destinatario;
    }

    public String getSugerencia() {
        return sugerencia;
    }

    public void setSugerencia(String sugerencia) {
        this.sugerencia = sugerencia;
    }

    @Override
    public String toString() {
        return "Sugerencia{" + "nombre=" + nombre + ", email=" + email + ", destinatario=" + destinatario + ", sugerencia=" + sugerencia + '}';
    }
    
    
}
