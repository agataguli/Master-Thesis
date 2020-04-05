package com.example.myapp3;

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
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@Slf4j
@Controller
public class DummyFrontPagesController {

    private final AuthorizeUser authorizeUser;

    private final CreateAccount createAccount;

    private final PutAnonymousReview putAnonymousReview;

    private final PutQuestionnaire putQuestionnaire;

    @GetMapping("getLoginForm")
    public String getLoginForm() {
        return "loginForm";
    }

    @PostMapping("loginF")
    public String loginF(@RequestParam("login") String login, @RequestParam("password") String password) {
        LoginResponse result = authorizeUser.authorize(new LoginData(login, password));
        return result.isSuccess() ? "loginOk" : "loginFail";
    }

    @PostMapping("createAccountF")
    public String createAccountF() {
        return "createAccountF";
    }

    @PostMapping("questionnaire1F")
    public String questionnaire1F() {
        return "questionnaire1F";
    }

    @PostMapping("anoReview1F")
    public String anoReview1F() {
        return "anoReview1F";
    }

    @PostMapping("createAccountA")
    public String createAccountA(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("email") String email,
                                 @RequestParam("comment") String comment) {
        NewAccountResponse result = createAccount.create(new NewAccountData(login, password, email, comment));
        return result.isSuccess() ? "loginForm" : "createAccountFail";
    }

    @PostMapping("questionnaire1A")
    public String questionnaire1A(@RequestParam("1") String p1,
                                  @RequestParam("2") String p2,
                                  @RequestParam("3") String p3,
                                  @RequestParam("4") String p4,
                                  @RequestParam("5") String p5,
                                  @RequestParam("6") String p6,
                                  @RequestParam("7") String p7,
                                  @RequestParam("8") String p8,
                                  @RequestParam("9") String p9,
                                  @RequestParam("10") String p10,
                                  @RequestParam("11") String p11,
                                  @RequestParam("12") String p12,
                                  @RequestParam("13") String p13,
                                  @RequestParam("14") String p14,
                                  @RequestParam("15") String p15,
                                  @RequestParam("16") String p16,
                                  @RequestParam("17") String p17,
                                  @RequestParam("18") String p18,
                                  @RequestParam("login") String login) {
        QuestionnaireDataExample1 questionnaire = new QuestionnaireDataExample1(p1,
                                                                                p2,
                                                                                p3,
                                                                                p4,
                                                                                p5,
                                                                                p6,
                                                                                p7,
                                                                                p8,
                                                                                p9,
                                                                                p10,
                                                                                p11,
                                                                                p12,
                                                                                p13,
                                                                                p14,
                                                                                p15,
                                                                                p16,
                                                                                p17,
                                                                                p18);
        QuestionnaireResponse result = putQuestionnaire.put(questionnaire, login, "https://dariusforoux.com/21-questions/");
        return result.isSuccess() ? "loginOk" : "operationError";
    }

    @PostMapping("anoReview1A")
    public String anoReview1A(@RequestParam("1") Boolean p1,
                              @RequestParam("2") Boolean p2,
                              @RequestParam("3") String p3,
                              @RequestParam("4") String p4,
                              @RequestParam("5") String p5) {
        AnonymousReviewDataExample1 data = new AnonymousReviewDataExample1(p1, p2, p3, p4, p5);
        AnonymousReviewResponse result = putAnonymousReview.put(data, "Example1");
        return result.isSuccess() ? "loginOk" : "operationError";
    }
}
