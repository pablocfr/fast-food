package com.fastfood.domain.seguridad.service;

import com.fastfood.domain.seguridad.model.SeguridadModel;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!security") // Solo se activa cuando security no está activo
public class SeguridadServiceDummy implements SeguridadService {

    @Override
    public SeguridadModel autenticacion(String username, String password) {
        return SeguridadModel.builder()
                .token("dummy-token-" + username)
                .refresh("dummy-refresh-" + username)
                .build();
    }

    @Override
    public SeguridadModel refrescar(String token) {
        return SeguridadModel.builder()
                .token("dummy-new-token")
                .refresh("dummy-new-refresh-token")
                .build();
    }
}