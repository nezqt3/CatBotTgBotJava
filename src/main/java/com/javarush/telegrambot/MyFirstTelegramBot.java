package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static com.javarush.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "Web_Tinder_Api_BOT";
    public static final String TOKEN = "7910150922:AAGTG8H3kSq-bc6OENHmsgw7HyJMMqESgos";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
				if (getMessageText().equals("/start")) {
					setUserGlory(0);
					sendPhotoMessageAsync("step_1_pic");
					sendTextMessageAsync(STEP_1_TEXT, Map.of(
						"Взлом холодильника", "step_1_btn")
					);
				}

				if (getCallbackQueryButtonKey().equals("step_1_btn")) {
					addUserGlory(20);
					sendPhotoMessageAsync("step_2_pic");
					sendTextMessageAsync(STEP_2_TEXT, Map.of(
						"Взять сосиску! +20 славы", "step_2_btn",
						"Взять рыбку! +20 славы", "step_2_btn",
						"Скинуть банку с огурцами! +20 славы", "step_2_btn")
					);
				}

				if (getCallbackQueryButtonKey().equals("step_2_btn")) {
					addUserGlory(20);
					sendPhotoMessageAsync("step_3_pic");
					sendTextMessageAsync(STEP_3_TEXT, Map.of(
						"Взлом робота-пылесоса", "step_3_btn")
					);
				}

			if (getCallbackQueryButtonKey().equals("step_3_btn")) {
				addUserGlory(20);
				sendPhotoMessageAsync("step_4_pic");
				sendTextMessageAsync(STEP_4_TEXT, Map.of(
					"Отправить робот-пылесос за едой! +30 славы", "step_4_btn",
					"Покататься на роботе-пылесосе! +30 славы", "step_4_btn",
					"Убежать от робота пылесоса! +30 славы", "step_4_btn")
				);
			}

			if (getCallbackQueryButtonKey().equals("step_4_btn")) {
				addUserGlory(30);
				sendPhotoMessageAsync("step_5_pic");
				sendTextMessageAsync(STEP_5_TEXT, Map.of(
					"Надеть и включить GoPro", "step_5_btn")
				);
			}

			if (getCallbackQueryButtonKey().equals("step_5_btn")) {
				addUserGlory(40);
				sendPhotoMessageAsync("step_6_pic");
				sendTextMessageAsync(STEP_6_TEXT, Map.of(
					"Снять свои проказни! +40 славы", "step_6_btn",
					"Сломать GoPro! +40 славы", "step_6_btn",
					"Записать видеоблог по разработке тг бота! +40 славы", "step_6_btn")
				);
			}

			if (getCallbackQueryButtonKey().equals("step_6_btn")) {
				addUserGlory(40);
				sendPhotoMessageAsync("step_7_pic");
				sendTextMessageAsync(STEP_7_TEXT, Map.of(
					"Взломать компьютер", "step_7_btn")
				);
			}
			if (getCallbackQueryButtonKey().equals("step_7_btn")) {
				addUserGlory(50);
				sendPhotoMessageAsync("step_8_pic");
				sendTextMessageAsync(STEP_8_TEXT, Map.of(
					"Далее", "step_8_btn")
				);
			}

			if (getCallbackQueryButtonKey().equals("step_8_btn")) {
				sendPhotoMessageAsync("final_pic");
				sendTextMessageAsync(FINAL_TEXT);
			}

			if (getMessageText().equals("/glory")) {
				int glory = getUserGlory();
				sendTextMessageAsync("Ваши очки славы: " + glory);
			}

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}

//			if (getMessageText().equals("/start")) {
//sendTextMessageAsync("Привет!");
//			}
//
//				if (getMessageText().equals("/bye")) {
//sendTextMessageAsync("Asta la vista, baby!");
//			}
//
//				if (getMessageText().contains("бомба")) {
//sendTextMessageAsync("Опасность!");
//			}
//
//				if (getMessageText().contains("картинка")) {
//sendPhotoMessageAsync("step_8_pic");
//			}
//
//				if (getMessageText().contains("кот")) {
//sendTextMessageAsync("Выбери номер кота: ", Map.of("кот1", "cat1", "кот2", "cat2"));
//	}
//
//	if (getCallbackQueryButtonKey().equals("cat1")) {
//sendPhotoMessageAsync("step_1_pic");
//			}
//
//				if (getCallbackQueryButtonKey().equals("cat2")) {
//sendPhotoMessageAsync("step_2_pic");
//			}
//
//				if (getMessageText().contains("опрос")) {
//sendTextMessageAsync("Ваше любимое сообщение", Map.of("Кот", "cat", "Собака", "dog"));
//	}
//
//	if (getCallbackQueryButtonKey().equals("cat")) {
//sendPhotoMessageAsync("step_4_pic");
//			}
//
//				if (getCallbackQueryButtonKey().equals("dog")) {
//sendPhotoMessageAsync("step_6_pic");
//			}
//
//				if (getMessageText().equals("smile")) {
//var message = getLastSentMessage();
//editTextMessageAsync(message.getMessageId(), message.getText() + " :) ");
//	}
