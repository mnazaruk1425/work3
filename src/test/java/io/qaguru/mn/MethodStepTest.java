package io.qaguru.mn;

import org.junit.jupiter.api.Test;

public class MethodStepTest {

    public BaseSteps steps = new BaseSteps();

    private static final String REPOSITORY ="eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "#68";

    @Test
    public void testIssueSearch(){
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepositoryFromSearch(REPOSITORY);
        steps.openRepositoryIssue();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);

    }


}
