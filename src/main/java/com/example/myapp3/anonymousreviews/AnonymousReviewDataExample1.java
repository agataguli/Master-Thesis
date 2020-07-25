package com.example.myapp3.anonymousreviews;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnonymousReviewDataExample1 extends AnonymousReviewData {

    private boolean areYouSatisfied;

    private boolean doYouWantSomeExtraPoint;

    private String whyYouShouldAchieveThem;

    private String whatAreYourLookingHere;

    private String whatIsYourHobby;
}
