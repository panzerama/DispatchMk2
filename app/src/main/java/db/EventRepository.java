package db;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import models.Event;

public class EventRepository {
    private EventDao mEventDao;
    private LiveData<List<Event>> mAllEvents;

    public EventRepository(Application application) {
        AppDatabase db = AppDatabase.getAppDatabase(application);
        mEventDao = db.eventDao();
        mAllEvents = mEventDao.getAllEvents();
    }

    public LiveData<List<Event>> getAllEvents() { return mAllEvents; }

    public void insert (Event event) { new insertAsyncTask(mEventDao).execute(event); }

    private static class insertAsyncTask extends AsyncTask<Event, Void, Void> {
        private EventDao mAsyncEventDao;

        insertAsyncTask(EventDao dao) { mAsyncEventDao = dao; }

        @Override
        protected Void doInBackground(final Event... params) {
            mAsyncEventDao.insert(params[0]); // TODO: 5/2/18 why is params an array here. understand this.
            return null;
        }
    }
}
