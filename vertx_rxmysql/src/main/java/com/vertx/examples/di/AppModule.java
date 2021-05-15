package com.vertx.examples.di;

import com.vertx.examples.config.MysqlClient;
import com.vertx.examples.controllers.IReviewController;
import com.vertx.examples.controllers.ReviewController;
import com.vertx.examples.mysql.IReviewDao;
import com.vertx.examples.mysql.ReviewDao;
import com.vertx.examples.services.IReviewService;
import com.vertx.examples.services.ReviewService;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.mysqlclient.MySQLPool;

@Module
public interface AppModule {

    @Provides
    static MySQLPool mysqlPool(Vertx vertx) {
        return MysqlClient.getMysqlClient(vertx);
    }

    @Binds
    IReviewController bindReviewController(ReviewController reviewController);

    @Binds
    IReviewService bindReviewService(ReviewService reviewService);

    @Binds
    IReviewDao bindReviewDao(ReviewDao reviewDao);

}
