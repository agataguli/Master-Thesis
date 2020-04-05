package com.example.myapp3.util;

import com.example.myapp3.anonymousreviews.AnonymousReviewData;
import com.example.myapp3.anonymousreviews.AnonymousReviewResponse;
import com.example.myapp3.login.LoginResponse;
import com.example.myapp3.register.NewAccountResponse;
import com.example.myapp3.userquestionnaires.QuestionnaireData;
import com.example.myapp3.userquestionnaires.QuestionnaireResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String serialize(LoginResponse loginResponse) throws JsonProcessingException {
        return mapper.writeValueAsString(loginResponse);
    }

    public static String serialize(NewAccountResponse response) throws JsonProcessingException {
        return mapper.writeValueAsString(response);
    }

    public static String serialize(AnonymousReviewResponse response) throws JsonProcessingException {
        return mapper.writeValueAsString(response);
    }

    public static String serialize(AnonymousReviewData data) throws JsonProcessingException {
        return mapper.writeValueAsString(data);
    }

    public static String serialize(QuestionnaireData questionnaireData) throws JsonProcessingException {
        return mapper.writeValueAsString(questionnaireData);
    }

    public static String serialize(QuestionnaireResponse response) throws JsonProcessingException {
        return mapper.writeValueAsString(response);
    }

}
