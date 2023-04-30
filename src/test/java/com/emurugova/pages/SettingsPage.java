package com.emurugova.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SettingsPage {

    private SelenideElement
            moreTab = $(MobileBy.id("org.wikipedia.alpha:id/nav_more_container")),
            settingTab = $(MobileBy.id("org.wikipedia.alpha:id/main_drawer_settings_container"));

 //Action methods
    public void openMoreTab () {
        moreTab.click();
    }
    public void openSettingTab () {
        settingTab.click();
    }
    public void chooseLanguageSettings () {
        $$(MobileBy.id("android:id/title"))
                .findBy(Condition.text("Wikipedia languages")).click();
    }
    public void addLanguage() {
        $$(MobileBy.id("org.wikipedia.alpha:id/wiki_language_title"))
                .findBy(Condition.text("ADD LANGUAGE")).click();
    }
    public void chooseLanguage(String chosenLanguage) {
        $$(MobileBy.id("org.wikipedia.alpha:id/localized_language_name"))
                .findBy(Condition.text(chosenLanguage)).click();
    }
    public void searchLanguage(String searchLanguage) {
        $(MobileBy.id("org.wikipedia.alpha:id/menu_search_language")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue(searchLanguage);
    }

//Check methods
    public void checkOriginalLanguage(String originalLanguage) {
        $(MobileBy.id("android:id/summary")).shouldHave(text(originalLanguage));
    }
    public void checkChosenLanguage(String originalLanguage, String chosenLanguage) {
        $(MobileBy.id("android:id/summary")).shouldHave(text(originalLanguage +", " + chosenLanguage));
    }
    public void checkSearchLanguage(String searchLanguage) {
        $(MobileBy.id("org.wikipedia.alpha:id/localized_language_name")).shouldHave(text(searchLanguage));
    }
}