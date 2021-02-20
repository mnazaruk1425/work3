package io.qaguru.mn;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class GitHubIssueTest1 {
    private static final String Base_URL = "http://github.com";
    private static final String ISSUES = "Issues" ;
    private static final String REPOSITORY ="eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "#68";


    @Test
    @Owner("eroshenkoam")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Issues")
    @Story("Poisk issue v sychestvuyuchem repozitorii")
    @Link(name = "Base URL",value = Base_URL)
    @Tags({@Tag("web"),@Tag("critical")})
    @DisplayName("Poisk issue po nomery v pepozitorii")
    public void testIssueSearch() {
        parameter("Repositiry",REPOSITORY);
        parameter("Issuue Number",ISSUE_NUMBER);

        step("open main page", () -> {
            open(Base_URL);

         });step("lookin for repository" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
          });
        step("move to repository" + REPOSITORY,() -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("perehodim v razdel ssulki" + ISSUES,() -> {
            $(withText(ISSUES)).click();

        });
        step("proveryaem chto issue s nomerom sychestvyet" + ISSUE_NUMBER + "sychestvyet",() ->{
            $(withText(ISSUE_NUMBER)).should(Condition.exist);
        });
    }

    @Test
    @Disabled
    @Owner("eroshenkoam")
    @Feature("Issues")
    @Story("Poisk issue")
    @Link(name = "Base URL",value = Base_URL)
    @Tags({@Tag("web"),@Tag("critical")})
    @DisplayName("Sozdanie issue po novoy pepozitorii")
    public void testIssueCreate() {
        parameter("Repositiry",REPOSITORY);
        parameter("Issuue Number",ISSUE_NUMBER);
        step("open main page", () -> {
            open(Base_URL);

        });
        step("lookin for repository" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("move to repository" + REPOSITORY,() -> {
            $(By.linkText(REPOSITORY + "a")).click();
        });
        step("perehodim v razdel ssulki" + ISSUES,() -> {
            $(withText(ISSUES)).click();

        });
        step("proveryaem chto issue s nomerom sychestvyet" + ISSUE_NUMBER + "sychestvyet",() ->{
            $(withText(ISSUE_NUMBER)).should(Condition.exist);
        });
    } }


