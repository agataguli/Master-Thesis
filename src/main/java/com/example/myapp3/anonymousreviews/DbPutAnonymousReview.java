package com.example.myapp3.anonymousreviews;

import static java.sql.Types.*;

import java.util.UUID;

import com.example.myapp3.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DbPutAnonymousReview implements PutAnonymousReview {

    private final NamedParameterJdbcTemplate cache;

    public DbPutAnonymousReview(NamedParameterJdbcTemplate cache) {
        this.cache = cache;
    }

    public AnonymousReviewResponse put(AnonymousReviewData data, String reviewName) {
        //language=TSQL
        try {
            String query =
                "INSERT INTO anonymous_reviews(id, anonymous_reviews_details, data)"
                    + "VALUES (:id, :anonymous_reviews_details, :serialized_data)";

            MapSqlParameterSource params =
                new MapSqlParameterSource("id", UUID.randomUUID())
                    .addValue("anonymous_reviews_details", reviewName)
                    .addValue("serialized_data", JsonUtil.serialize(data), OTHER);
            params.addValue("anonymous_reviews_details", reviewName);
            params.addValue("serialized_data", JsonUtil.serialize(data), OTHER);

            cache.update(query, params);

            return new AnonymousReviewResponse(true);
        } catch (Exception e) {
            log.error("Unexpected error during put anonymousReviewData", e);
            return new AnonymousReviewResponse(false);
        }

    }
}
