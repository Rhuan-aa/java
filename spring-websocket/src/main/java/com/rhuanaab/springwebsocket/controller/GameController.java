package com.rhuanaab.springwebsocket.domain;

import com.rhuanaab.springwebsocket.records.Game;
import com.rhuanaab.springwebsocket.records.GameState;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class GameController {
    private SimpMessagingTemplate simpMessagingTemplate = null;

    public GameController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/game/{gameId}/play")
    public void play(@DestinationVariable UUID gameId, GameState gameState) {
        GameState newState = new GameState(
                gameState.opponentId(),
                gameState.others(),
                gameState.playerOfTurnId());
        Game game = new Game(gameId, newState);
        simpMessagingTemplate.convertAndSend("/topic/" + gameId, game);
    }
}
