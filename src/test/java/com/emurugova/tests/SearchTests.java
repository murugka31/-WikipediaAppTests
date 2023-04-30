package com.emurugova.tests;

import com.emurugova.pages.SearchPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.emurugova.tests.TestData.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    SearchPage searchPage = new SearchPage();
    @Test
    @DisplayName("Успешный поиск")
    void searchWithResultsTest() {

        step("Нажать на поле Поиск и ввести значение", () -> {
            searchPage.openSearchField();
            searchPage.setValue(successfulValue);
        });
        step("Проверить результаты успешного поиска", () -> {
            searchPage.checkSuccessfulResult();
        });
    }

    @Test
    @DisplayName("Неуспешный поиск")
    void searchWithNoResultsTest() {

        step("Нажать на поле Поиск и ввести значение", () -> {
            searchPage.openSearchField();
            searchPage.setValue(unsuccessfulValue);
        });
        step("Проверить результаты неуспешного поиска", () -> {
            searchPage.checkUnsuccessfulResult();
        });
    }

    @Test
    @DisplayName("Успешный результат имеет описание")
    void resultDescriptionTest() {

        step("Нажать на поле Поиск и ввести значение", () -> {
            searchPage.openSearchField();
            searchPage.setValue(successfulValue);
        });
        step("Проверить, что успешный результат имеет описание", () -> {
            searchPage.checkDescription(description);
        });
    }
}