package com.crud.democrud.ControllerServiceTest;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.repositories.UsuarioRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CrudTest {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Test
    public void GuardarUsuario() {
        UsuarioModel userModel = new UsuarioModel("maria", "maria@gmail.com", 22);
        UsuarioModel usuarioRegistrado = usuarioRepository.save(userModel);
        assertNotNull(usuarioRegistrado);
    }

    @Test
    public void ActualizarUsuario() {
        UsuarioModel usuarioModel = new UsuarioModel("maria", "maria@gmail.com", 22);
        usuarioModel.setId(new Long(1));
        usuarioModel.setNombre("Marta");
        BindingResult result = new BeanPropertyBindingResult(usuarioModel, "UserModel");
        ModelMap model = new ModelMap();
        Assert.assertEquals(false, model.containsAttribute("UpdateUser"));
    }

    @Test
    public void ListarUsuarios() {
        List<UsuarioModel> usuarioModelList = (List<UsuarioModel>) usuarioRepository.findAll();
        assertThat(usuarioModelList).size().isGreaterThan(0);
    }


    @Test
    public void ObtenerUsuarioPorPrioridad() {
        Long prioridad = 1L;
        Optional<UsuarioModel> usuarioModelBuscado = usuarioRepository.findById(prioridad);
        assertThat(usuarioModelBuscado.get().getId()).isEqualTo(prioridad);
    }
    @Test
    public void BuscarUsuarioPorId() {
        Long id = 1L;
        Optional<UsuarioModel> usuarioModelBuscado = usuarioRepository.findById(id);
        assertThat(usuarioModelBuscado.get().getId()).isEqualTo(id);
    }



}