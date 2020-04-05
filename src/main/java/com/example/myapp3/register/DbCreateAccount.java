package com.example.myapp3.register;

import com.example.myapp3.login.AuthorizeUser;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DbCreateAccount implements CreateAccount {

    private final NamedParameterJdbcTemplate cache;

    public DbCreateAccount(NamedParameterJdbcTemplate cache, AuthorizeUser authorizeUser) {
        this.cache = cache;
    }

    public NewAccountResponse create(NewAccountData newAccountData) {
        if (suchUserExists(newAccountData.getName()))
            return new NewAccountResponse(false);

        //language=TSQL
        String query = "INSERT INTO users(name, password, email, comment)"
            + "VALUES (:name, :password, :email, :comment);";

        MapSqlParameterSource params = new MapSqlParameterSource("name", newAccountData.getName());
        params.addValue("password", newAccountData.getPassword());
        params.addValue("email", newAccountData.getEmail());
        params.addValue("comment", newAccountData.getComment());

        cache.update(query, params);

        return new NewAccountResponse(true);
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
}
