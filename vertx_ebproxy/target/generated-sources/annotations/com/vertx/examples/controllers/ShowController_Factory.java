package com.vertx.examples.controllers;

import com.vertx.examples.dal.DataLayerService;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ShowController_Factory implements Factory<ShowController> {
  private final Provider<DataLayerService> dataLayerServiceProvider;

  public ShowController_Factory(Provider<DataLayerService> dataLayerServiceProvider) {
    this.dataLayerServiceProvider = dataLayerServiceProvider;
  }

  @Override
  public ShowController get() {
    return provideInstance(dataLayerServiceProvider);
  }

  public static ShowController provideInstance(
      Provider<DataLayerService> dataLayerServiceProvider) {
    ShowController instance = new ShowController();
    ShowController_MembersInjector.injectDataLayerService(instance, dataLayerServiceProvider.get());
    return instance;
  }

  public static ShowController_Factory create(Provider<DataLayerService> dataLayerServiceProvider) {
    return new ShowController_Factory(dataLayerServiceProvider);
  }

  public static ShowController newShowController() {
    return new ShowController();
  }
}
