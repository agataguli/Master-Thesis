create table if not exists user_questionnaires
(
    id uuid not null
        constraint user_questionnaires_pkey
            primary key,
    login varchar not null,
    questionnaire_name varchar not null,
    data jsonb
);