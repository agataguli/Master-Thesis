package com.example.myapp3.userquestionnaires;

public interface PutQuestionnaire {

    QuestionnaireResponse put(QuestionnaireData questionnaireData, String login, String questionnaireName);
}
