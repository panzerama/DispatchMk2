package db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import models.Event;

/**
 * Created by jd on 3/13/18.
 */

@Database(entities = {Event.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;
    public abstract EventDao eventDao();

    public static AppDatabase getAppDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "event-database")
                            .addCallback(sDatabaseInitCallback) // TODO: 5/2/18 remove this after app is built
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    // initialization for db on creation
    private static RoomDatabase.Callback sDatabaseInitCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final EventDao eventDao;

        public PopulateDbAsync(AppDatabase db) {
            this.eventDao = db.eventDao();
        }

        @Override
        public Void doInBackground(final Void... params) {
            eventDao.deleteAll();

            MockDataGenerator generator = new MockDataGenerator();

            Event event1 = generator.generateSimpleEvent();
            eventDao.insert(event1);

            Event event2 = generator.generateSimpleEvent();
            eventDao.insert(event2);

            Event event3 = generator.generateSimpleEvent();
            eventDao.insert(event3);

            Event event4 = generator.generateSimpleEvent();
            eventDao.insert(event4);

            return null;
        }
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
