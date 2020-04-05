package com.example.myapp3.userquestionnaires;

import java.sql.Types;
import java.util.UUID;

import com.example.myapp3.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DbPutQuestionnaire implements PutQuestionnaire {

    private final NamedParameterJdbcTemplate cache;

    public DbPutQuestionnaire(NamedParameterJdbcTemplate cache) {
        this.cache = cache;
    }

    public QuestionnaireResponse put(QuestionnaireData questionnaireData, String login, String questionnaireName) {
        if (!suchUserExists(login) || userAlreadyPuttedGivenQuestionnaire(login, questionnaireName))
            return new QuestionnaireResponse(false);

        try {
            //language=TSQL
            String query = "INSERT INTO user_questionnaires(id, login, questionnaire_name, data)"
                + "VALUES (:id, :login, :questionnaire_name, :serialized_data)"
                + ";";

            MapSqlParameterSource params = new MapSqlParameterSource("id", UUID.randomUUID());
            params.addValue("login", login);
            params.addValue("questionnaire_name", questionnaireName);
            params.addValue("serialized_data", JsonUtil.serialize(questionnaireData), Types.OTHER);

            cache.update(query, params);

            return new QuestionnaireResponse(true);
        } catch (Exception e) {
            log.error("Unexpected error during put questionnaireData", e);
            return new QuestionnaireResponse(false);
        }
    }

    private Boolean suchUserExists(String name) {
        //language=TSQL
        String query = "SELECT EXISTS(SELECT * "
            + "FROM users "
            + "WHERE name = :name"
            + ");";

        MapSqlParameterSource params = new MapSqlParameterSource("name", name);

        return cache.queryForObject(query, params, Boolean.class);
    }

    private Boolean userAlreadyPuttedGivenQuestionnaire(String login, String questionnaireName) {
        //language=TSQL
        String query = "SELECT EXISTS(SELECT * "
            + "FROM user_questionnaires "
            + "WHERE login = :login "
            + "AND questionnaire_name = :questionnaire_name"
            + ");";

        MapSqlParameterSource params = new MapSqlParameterSource("login", login);
        params.addValue("questionnaire_name", questionnaireName);

        return cache.queryForObject(query, params, Boolean.class);
    }
}
