package com.emurugova.tests;

import com.emurugova.pages.TabPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TabsTests extends TestBase {

    TabPage tabPage = new TabPage();
    @Test
    @DisplayName("Проверка вкладок приложения")
    void checkTabsTest() {
        step("Проверить вкладку Сохраненные", () -> {
            tabPage.openSavedTab();
            tabPage.checkSavedTab();
        });
        step("Проверить вкладку Поиск", () -> {
            tabPage.openSearchTab();
            tabPage.checkSearchTab();
        });
        step("Проверить вкладку Редактирование", () -> {
            tabPage.openEditsTab();
            tabPage.checkEditsTab();
        });
        step("Проверить вкладку Еще", () -> {
            tabPage.openMoreTab();
            tabPage.checkMoreTab();
        });
        step("Проверить шторку Настройки", () -> {
            tabPage.openSettingTab();
            tabPage.checkSettingTab();
        });
    }
}