package ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import jd.dispatchmk2.R;
import models.Event;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventViewHolder> {
    class EventViewHolder extends RecyclerView.ViewHolder {
        private final TextView mEventItemView;

        public EventViewHolder(View itemView) {
            super(itemView);
            mEventItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Event> mEvents;

    public EventListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new EventViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        if (mEvents != null) {
            Event current = mEvents.get(position);
            holder.mEventItemView.setText(current.getAddress());
        } else {
            //data not yet ready
            holder.mEventItemView.setText("The event has not happened yet...");
        }
    }

    public void setEvents(List<Event> events) {
        mEvents = events;
        notifyDataSetChanged(); // TODO: 5/2/18 I'm under the impression that this notifies an observer. check and make sure that's accurate.
    }

    @Override
    public int getItemCount() {
        if (mEvents != null) { return mEvents.size(); }
        else { return 0; }
    }
}

