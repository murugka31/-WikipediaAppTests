package com.emurugova.tests;

import com.emurugova.pages.SettingsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.emurugova.tests.TestData.*;
import static io.qameta.allure.Allure.step;

public class SettingsTests extends TestBase {

    SettingsPage settingsPage = new SettingsPage();
    @Test
    @DisplayName("Проверить язык приложения")
    void appLanguageTest() {

        step("Зайти в настройки", () -> {
            settingsPage.openMoreTab();
            settingsPage.openSettingTab();
        });
        step("Проверить, что оригинальный язык приложения", () -> {
            settingsPage.checkOriginalLanguage(originalLanguage);
        });
    }

    @Test
    @DisplayName("Добавить язык приложения")
    void changeAppLanguageTest() {

        step("Зайти в настройки", () -> {
            settingsPage.openMoreTab();
            settingsPage.openSettingTab();
        });
        step("Выбрать настройку языка", () -> {
            settingsPage.chooseLanguageSettings();
        });
        step("Нажать на Добавить язык", () -> {
            settingsPage.addLanguage();
        });
        step("Выбрать язык", () -> {
            settingsPage.chooseLanguage(chosenLanguage);
        });
        step("Вернуться в общее меню настроек", () -> {
            back();
        });
        step("Проверить, что язык добавлен", () -> {
            settingsPage.checkChosenLanguage(originalLanguage, chosenLanguage);
        });
    }

    @Test
    @DisplayName("Поиск языка приложения")
    void searchAppLanguageTest() {
        step("Зайти в настройки", () -> {
            settingsPage.openMoreTab();
            settingsPage.openSettingTab();
        });
        step("Выбрать настройку языка", () -> {
            settingsPage.chooseLanguageSettings();
        });
        step("Нажать на Добавить язык", () -> {
            settingsPage.addLanguage();
        });
        step("Ввести нужный язык в строку поиска", () -> {
            settingsPage.searchLanguage(searchLanguage);
        });
        step("Проверить наличие языка", () -> {
           settingsPage.checkSearchLanguage(searchLanguage);
        });
    }
}