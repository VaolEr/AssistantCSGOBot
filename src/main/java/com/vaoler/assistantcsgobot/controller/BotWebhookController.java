package com.vaoler.assistantcsgobot.controller;

import com.vaoler.assistantcsgobot.bot.AssistantCSGOBot;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "${app.endpoints.base_path}",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class BotWebhookController {

    private final AssistantCSGOBot assistantCSGOBot;

    @PostMapping(path = "/assistant-csgo-telegram-bot")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return assistantCSGOBot.onWebhookUpdateReceived(update);
    }
}
