package com.vertx.examples.services;

import com.vertx.examples.mysql.IReviewDao;
import com.vertx.examples.pojo.ReviewPojo;
import io.reactivex.Single;
import io.vertx.core.json.JsonObject;

import javax.inject.Inject;

public class ReviewService implements IReviewService {

    @Inject
    ReviewService(){
    }

    @Inject
    IReviewDao reviewDao;

    @Override
    public Single<ReviewPojo> getReviews() {
        return reviewDao.getReview();
    }
}
