package com.salamquran.android.dao.translation

interface TranslationRowData {
  fun isSeparator(): Boolean
  fun name(): String
  fun needsUpgrade(): Boolean
}