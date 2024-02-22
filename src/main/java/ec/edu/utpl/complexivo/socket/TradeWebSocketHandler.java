package ec.edu.utpl.complexivo.socket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ec.edu.utpl.complexivo.dto.MantenimientoDto;
import ec.edu.utpl.complexivo.entity.Mantenimiento;
import ec.edu.utpl.complexivo.repository.MantenimientoRepository;
import ec.edu.utpl.complexivo.service.MantenimientoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@Component
public class TradeWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private MantenimientoService mantenimientoService;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sendData(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        sendData(session);
    }

    private void sendData(WebSocketSession session) throws Exception {
        List<MantenimientoDto> mantenimientos = mantenimientoService.findByEstado("N");
        TextMessage message = new TextMessage(objectMapper.writeValueAsString(mantenimientos));
        session.sendMessage(message);
        Thread.sleep(1000);
        sessions.add(session);
    }
}
