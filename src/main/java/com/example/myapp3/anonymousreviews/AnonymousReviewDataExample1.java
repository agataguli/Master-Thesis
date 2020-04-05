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

    private boolean areYouSatisfied; //1

    private boolean doYouWantSomeExtraPoint; //2

    private String whyYouShouldAchieveThem; //3

    private String whatAreYourLookingHere; //4

    private String whatIsYourHobby; //5
}
