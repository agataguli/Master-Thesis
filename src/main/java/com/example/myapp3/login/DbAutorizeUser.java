package com.example.myapp3.login;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DbAutorizeUser implements AuthorizeUser {

    private final NamedParameterJdbcTemplate cache;

    public DbAutorizeUser(NamedParameterJdbcTemplate cache) {
        this.cache = cache;
    }

    public LoginResponse authorize(LoginData loginData) {
        //language=TSQL
        String query = "SELECT EXISTS(SELECT * "
            + "FROM users "
            + "WHERE name = :name "
            + "AND password = :password"
            + ");";

        MapSqlParameterSource params = new MapSqlParameterSource("name", loginData.getLogin());
        params.addValue("password", loginData.getPassword());

        Boolean exists = cache.queryForObject(query, params, Boolean.class);

        return new LoginResponse(exists);
    }
}
