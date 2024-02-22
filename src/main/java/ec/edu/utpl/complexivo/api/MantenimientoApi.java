package ec.edu.utpl.complexivo.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.edu.utpl.complexivo.dto.MantenimientoDto;
import ec.edu.utpl.complexivo.dto.MantenimientoRequestDto;
import ec.edu.utpl.complexivo.entity.Mantenimiento;
import ec.edu.utpl.complexivo.service.MantenimientoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.PUT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mantenimiento")
public class MantenimientoApi {

    @Autowired
    private MantenimientoService mantenimientoService;

    private final Map<String, WebSocketSession> sessions;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public MantenimientoApi(final Map<String, WebSocketSession> sessions) {
        this.sessions = sessions;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(HttpServletRequest request, @RequestBody Mantenimiento mantenimiento) {
        mantenimientoService.save(mantenimiento);
        /*Mantenimiento mantenimientoSave = mantenimientoService.save(mantenimiento);
        Principal principal = request.getUserPrincipal();
        var session = sessions.get(principal.getName());
        if (session == null) {
            throw new IllegalStateException(principal.getName() + " is not connected");
        }
        try {
            TextMessage message = new TextMessage(objectMapper.writeValueAsString(mantenimientoSave));
            session.sendMessage(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/solicitudes/{estado}")
    public ResponseEntity<List<MantenimientoDto>> getByEstado(@PathVariable String estado) {
        return ResponseEntity.ok(mantenimientoService.findByEstado(estado));
    }

    @PutMapping("/update-mantenimiento")
    public ResponseEntity<Void> updateMantenimiento(@RequestBody MantenimientoRequestDto request) {
        mantenimientoService.updateMantenimiento(request);
        return ResponseEntity.noContent().build();
    }

}
