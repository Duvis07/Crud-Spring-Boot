package com.crud.democrud.ServicesTest;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.models.UsuarioRol;
import com.crud.democrud.repositories.UsuarioRepository;
import com.crud.democrud.services.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.*;

import static  org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioServiceTest {


    private final String TEST = "Test";
    private final Long TEST_LONG = 1L;


    @Autowired
    UsuarioRepository usuarioRepository;

    @Test
    public void testGuardarUsuario(){

        Set<UsuarioRol> usuarioRolSet = new HashSet<>();
        UsuarioRol usuarioRol = new UsuarioRol(TEST_LONG, TEST_LONG, "Vendedor");
        usuarioRolSet.add(usuarioRol);

        UsuarioModel usuarioModel=new UsuarioModel(TEST_LONG, "Santiago","aqua@gmail.com",99, usuarioRolSet);
        UsuarioModel usuarioModelRegistrado = usuarioRepository.save(usuarioModel);
        assertNotNull(usuarioModelRegistrado);
    }

    @Test
    public void testBuscarUsuarioPorId(){
        Long idBuscado=1L;
        Optional<UsuarioModel> usuarioModelBuscado=usuarioRepository.findById(idBuscado);
        assertThat(usuarioModelBuscado.get().getId()).isEqualTo(idBuscado);
    }

    @Test
    public void testListarUsuarios(){
        List<UsuarioModel> usuarioModelList=(List<UsuarioModel>) usuarioRepository.findAll();
        assertThat(usuarioModelList).size().isGreaterThan(0);
    }
}
