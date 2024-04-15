package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.usuario.DataAutentication;
import med.voll.api.domain.usuario.Usuario;
import med.voll.api.infra.security.DataTokenJwt;
import med.voll.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DataAutentication dataAutentication) {

        var authenticationToken = new UsernamePasswordAuthenticationToken(dataAutentication.login(), dataAutentication.senha());

        var authentication = authenticationManager.authenticate(authenticationToken);

        var tokenJwt = tokenService.generateToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DataTokenJwt(tokenJwt));

    }
}
