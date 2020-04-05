package com.example.myapp3;

import javax.ws.rs.core.Response;

import com.example.myapp3.anonymousreviews.AnonymousReviewDataExample1;
import com.example.myapp3.anonymousreviews.AnonymousReviewResponse;
import com.example.myapp3.anonymousreviews.PutAnonymousReview;
import com.example.myapp3.login.AuthorizeUser;
import com.example.myapp3.login.LoginData;
import com.example.myapp3.login.LoginResponse;
import com.example.myapp3.register.CreateAccount;
import com.example.myapp3.register.NewAccountData;
import com.example.myapp3.register.NewAccountResponse;
import com.example.myapp3.userquestionnaires.PutQuestionnaire;
import com.example.myapp3.userquestionnaires.QuestionnaireDataExample1;
import com.example.myapp3.userquestionnaires.QuestionnaireResponse;
import com.example.myapp3.util.JsonUtil;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Component
@RestController
@RequestMapping("/")
@Api("MY APP -  API")
public class MyApi {

    private final AuthorizeUser authorizeUser;

    private final CreateAccount createAccount;

    private final PutAnonymousReview putAnonymousReview;

    private final PutQuestionnaire putQuestionnaire;

    public MyApi(AuthorizeUser authorizeUser, CreateAccount createAccount, PutAnonymousReview putAnonymousReview,
                 PutQuestionnaire putQuestionnaire) {
        this.authorizeUser = authorizeUser;
        this.createAccount = createAccount;
        this.putAnonymousReview = putAnonymousReview;
        this.putQuestionnaire = putQuestionnaire;
    }

    @GetMapping("test")
    public Response test() {
        log.info("Test!");
        return Response.ok("OK!").build();
    }

    @PostMapping("login")
    public Response login(@RequestBody LoginData loginData) {
        log.info("Try of login by: " + loginData);
        try {
            LoginResponse response = authorizeUser.authorize(loginData);
            return Response.ok(JsonUtil.serialize(response)).build();
        } catch (Exception e) {
            return error("unable to login - server error");
        }
    }

    @PostMapping("createAccount")
    public Response createAccount(@RequestBody NewAccountData newAccountData) {
        log.info("Try of creating account with: " + newAccountData);
        try {
            NewAccountResponse response = createAccount.create(newAccountData);
            return Response.ok(JsonUtil.serialize(response)).build();
        } catch (Exception e) {
            return error("unable to create account - server error");
        }
    }

    @PostMapping("putAnonymousReviewE1")
    public Response putAnonymousReviewE1(@RequestBody AnonymousReviewDataExample1 anonymousReview) {
        log.info("Putting review: " + anonymousReview);
        try {
            AnonymousReviewResponse response = putAnonymousReview.put(anonymousReview, "Example1");
            return Response.ok(JsonUtil.serialize(response)).build();
        } catch (Exception e) {
            return error("unable to create account - server error");
        }
    }

    @PostMapping("putUserQuestionnaireE1")
    public Response putUserQuestionnaireE1(@RequestBody QuestionnaireDataExample1Request questionnaireRequest) {
        log.info("Putting questionnaire: " + questionnaireRequest);
        try {
            QuestionnaireResponse response = putQuestionnaire.put(questionnaireRequest.questionnaireData,
                                                                  questionnaireRequest.loginData.getLogin(),
                                                                  "https://dariusforoux.com/21-questions/");
            return Response.ok(JsonUtil.serialize(response)).build();
        } catch (Exception e) {
            return error("unable to create account - server error");
        }
    }

    private Response error(String errorMessage) {
        return Response.ok().entity("<error>" + errorMessage + "</error>").build();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class QuestionnaireDataExample1Request {

        private QuestionnaireDataExample1 questionnaireData;

        private LoginData loginData;
    }
}
