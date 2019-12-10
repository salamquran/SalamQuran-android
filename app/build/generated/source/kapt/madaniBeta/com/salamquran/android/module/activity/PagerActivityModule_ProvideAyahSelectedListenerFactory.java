// Generated by Dagger (https://google.github.io/dagger).
package com.salamquran.android.module.activity;

import com.salamquran.android.ui.helpers.AyahSelectedListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class PagerActivityModule_ProvideAyahSelectedListenerFactory implements Factory<AyahSelectedListener> {
  private final PagerActivityModule module;

  public PagerActivityModule_ProvideAyahSelectedListenerFactory(PagerActivityModule module) {
    this.module = module;
  }

  @Override
  public AyahSelectedListener get() {
    return proxyProvideAyahSelectedListener(module);
  }

  public static PagerActivityModule_ProvideAyahSelectedListenerFactory create(
      PagerActivityModule module) {
    return new PagerActivityModule_ProvideAyahSelectedListenerFactory(module);
  }

  public static AyahSelectedListener proxyProvideAyahSelectedListener(
      PagerActivityModule instance) {
    return Preconditions.checkNotNull(instance.provideAyahSelectedListener(), "Cannot return null from a non-@Nullable @Provides method");}
}