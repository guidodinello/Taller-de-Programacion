package model.logica.clases;

import java.util.GregorianCalendar;
//import java.util.List;

public class Usuario {

    protected String nickname, email, nombre, apellido, contrasena, imgDir;
    protected GregorianCalendar fechaNac;
    
    public Usuario(String nickname, String email, String nombre, String apellido, String contrasena, GregorianCalendar fechaNac, String imgDir) {
        this.nickname = nickname;
        this.email = email;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.imgDir = imgDir;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
    public String getContrasena() {
        return contrasena;
    }
    
    public String getImgDir() {
        return imgDir;
    }
    
    public GregorianCalendar getFechaNac() {
        return fechaNac;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void setImg(String img) {
        this.imgDir = img;
    }
    
    public void setFechaNac(GregorianCalendar fechaNac) {
        this.fechaNac = fechaNac;
    }

}
