package ec.edu.utpl.complexivo.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.edu.utpl.complexivo.entity.Mantenimiento;
import ec.edu.utpl.complexivo.service.MantenimientoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.security.Principal;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class NotificationsController {

    private final Map<String, WebSocketSession> sessions;

    @Autowired
    private MantenimientoService mantenimientoService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/notifications")
    public ResponseEntity<Void> createNotification(HttpServletRequest request,
                                   @RequestBody Mantenimiento mantenimiento) throws IOException {
        Mantenimiento mantenimientoSave = mantenimientoService.save(mantenimiento);
        Principal principal = request.getUserPrincipal();
        var session = sessions.get(principal.getName());
        if (session == null) {
            throw new IllegalStateException(principal.getName() + " is not connected");
        }
        TextMessage message = new TextMessage(objectMapper.writeValueAsString(mantenimientoSave));
        session.sendMessage(message);
        return ResponseEntity.noContent().build();
    }

}
