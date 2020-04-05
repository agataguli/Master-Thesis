package com.example.myapp3.anonymousreviews;

public interface PutAnonymousReview {
    AnonymousReviewResponse put(AnonymousReviewData anonymousReviewData, String reviewName);
}
