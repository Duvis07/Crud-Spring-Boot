package com.crud.democrud.controllers;


import com.crud.democrud.models.UsuarioRol;
import com.crud.democrud.services.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/usuarioRol")
public class UsuarioRolController {

    @Autowired
    UsuarioRolService usuarioRolService;

    @GetMapping()
    public ArrayList<UsuarioRol> obtenerUsuariosRol() {
        return usuarioRolService.obtenerUsuariosRol();
    }

    @PostMapping()
    public UsuarioRol guardarUsuarioRol(@RequestBody UsuarioRol usuarioRol) {
        return this.usuarioRolService.guardarUsuarioRol(usuarioRol);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioRol> obtenerUsuarioRolPorId(@PathVariable("id") Long id) {
        return this.usuarioRolService.obtenerUsuarioRolPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.usuarioRolService.eliminarUsuarioRol(id);
        if (ok) {
            return "Se eliminó el usuarioRol con id " + id;
        } else {
            return "No pudo eliminar el usuarioRol con id" + id;
        }
    }

    @PutMapping(value = "/{id}")
    public UsuarioRol actualizarUsuarioRol(@RequestBody UsuarioRol usuarioRol, @PathVariable Long id){
        return usuarioRolService.actualizarUsuarioRol(usuarioRol,id);
    }
}
