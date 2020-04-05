create table if not exists anonymous_reviews
(
    id uuid not null
        constraint anonymous_reviews_pkey
            primary key,
    anonymous_reviews_details varchar not null,
    data jsonb
);