package com.vertx.examples.mysql;

import com.vertx.examples.pojo.ReviewPojo;
import io.reactivex.Single;
import io.vertx.core.json.JsonObject;

public interface IReviewDao {

    public Single<ReviewPojo> getReview();
}
