package com.vertx.examples.controllers;

import com.vertx.examples.dal.DataLayerService;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ShowController_MembersInjector implements MembersInjector<ShowController> {
  private final Provider<DataLayerService> dataLayerServiceProvider;

  public ShowController_MembersInjector(Provider<DataLayerService> dataLayerServiceProvider) {
    this.dataLayerServiceProvider = dataLayerServiceProvider;
  }

  public static MembersInjector<ShowController> create(
      Provider<DataLayerService> dataLayerServiceProvider) {
    return new ShowController_MembersInjector(dataLayerServiceProvider);
  }

  @Override
  public void injectMembers(ShowController instance) {
    injectDataLayerService(instance, dataLayerServiceProvider.get());
  }

  public static void injectDataLayerService(
      ShowController instance, DataLayerService dataLayerService) {
    instance.dataLayerService = dataLayerService;
  }
}
