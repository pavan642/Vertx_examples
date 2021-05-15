package com.vertx.examples.services;

import com.vertx.examples.pojo.ReviewPojo;
import io.reactivex.Single;
import io.vertx.core.json.JsonObject;

import java.util.concurrent.Flow;

public interface IReviewService {
    Single<ReviewPojo> getReviews();
}
