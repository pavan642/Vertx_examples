package com.vertx.examples.mysql;

import com.vertx.examples.pojo.ReviewPojo;
import io.reactivex.Single;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.mysqlclient.MySQLPool;
import io.vertx.reactivex.sqlclient.Row;
import io.vertx.reactivex.sqlclient.RowSet;

import javax.inject.Inject;

public class ReviewDao  implements IReviewDao{

    private final Logger logger = LoggerFactory.getLogger(ReviewDao.class);

    @Inject
    ReviewDao(){

    }

    @Inject
    MySQLPool mySQLPool;

    public Single<ReviewPojo> getReview(){

        return mySQLPool
                .preparedQuery("select * from reviews where id = 1")
                .rxExecute()
                .map(rows -> {
                    RowSet<Row> rowResultSet = rows;
                    logger.info("got response from DB");
                    ReviewPojo reviewPojo = new ReviewPojo();
                    for (Row rowSet: rowResultSet) {
                        reviewPojo = new ReviewPojo(rowSet.getInteger("id"),
                        rowSet.getInteger("customer_id"), rowSet.getString("review"));
                    }
                    return reviewPojo;
//                    JsonObject jsonObject  = new JsonObject();
//                    for (Row rowSet: rowResultSet) {
//                        jsonObject.put("id", rowSet.getInteger("id"));
//                        jsonObject.put("customer_id", rowSet.getInteger("customer_id"));
//                        jsonObject.put("review", rowSet.getString("review"));
//                    }

//                    return  jsonObject;
                });
    }

}
