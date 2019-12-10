// Generated by Dagger (https://google.github.io/dagger).
package com.ermile.data.page.provider;

import com.ermile.data.source.PageProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class QuranPageModule_ProvideMadaniPageSetFactory implements Factory<PageProvider> {
  private static final QuranPageModule_ProvideMadaniPageSetFactory INSTANCE = new QuranPageModule_ProvideMadaniPageSetFactory();

  @Override
  public PageProvider get() {
    return proxyProvideMadaniPageSet();
  }

  public static QuranPageModule_ProvideMadaniPageSetFactory create() {
    return INSTANCE;
  }

  public static PageProvider proxyProvideMadaniPageSet() {
    return Preconditions.checkNotNull(QuranPageModule.provideMadaniPageSet(), "Cannot return null from a non-@Nullable @Provides method");}
}