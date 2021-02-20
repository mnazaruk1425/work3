package io.qaguru.mn;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepTest {
    private static final String Base_URL = "http://github.com";
    private static final String ISSUES = "Issues" ;
    private static final String REPOSITORY ="eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "#68";

    @Test
    public void testIssueSearch(){

        step("open main page", () -> {
            open(Base_URL);

        });
        step("lookin for repository" + REPOSITORY, () -> {
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
        step("proveryaem chto issue s nomeroom sychestvyet" + ISSUE_NUMBER + "sychestvyet",() ->{
            $(withText(ISSUE_NUMBER)).should(Condition.exist);
        });

    }
}
