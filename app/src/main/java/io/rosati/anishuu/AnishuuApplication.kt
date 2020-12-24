package io.rosati.anishuu

import android.app.Application
import io.rosati.anishuu.db.CollectionDatabase
import io.rosati.anishuu.db.manga.MangaRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class AnishuuApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { CollectionDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { MangaRepository(database.mangaDao()) }
}