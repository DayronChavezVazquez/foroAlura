package com.example.foroAlura.Controller;


import com.example.foroAlura.domain.Foro.Usuarios.DatosAutenticacionUsuario;
import com.example.foroAlura.domain.Foro.Usuarios.Usuario;
import com.example.foroAlura.infra.security.DatosJWTToken;
import com.example.foroAlura.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){


        Authentication authToken= new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.correoElectronico(), datosAutenticacionUsuario.contraseña());
         var usuarioAutenticado= authenticationManager.authenticate(authToken);
        var JwtToken= tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JwtToken));


    }
}