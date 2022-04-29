package com.crud.democrud.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombre;
    private String email;
    private Integer prioridad;
    @OneToMany(cascade = CascadeType.ALL,  orphanRemoval = true)
    private Set<UsuarioRol> usuarioRolSet;

    public UsuarioModel() {

    }

    public UsuarioModel(String nombre, String email, Integer prioridad) {
        this.nombre = nombre;
        this.email = email;
        this.prioridad = prioridad;
    }

    public UsuarioModel(Long id, String nombre, String email, Integer prioridad, Set<UsuarioRol> usuarioRolSet) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.prioridad = prioridad;
        this.usuarioRolSet = usuarioRolSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public Set<UsuarioRol> getUsuarioRolSet() {
        return usuarioRolSet;
    }

    public void setUsuarioRolSet(Set<UsuarioRol> usuarioRolSet) {
        this.usuarioRolSet = usuarioRolSet;
    }
}