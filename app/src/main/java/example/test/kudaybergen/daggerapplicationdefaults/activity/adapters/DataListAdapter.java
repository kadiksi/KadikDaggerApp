package example.test.kudaybergen.daggerapplicationdefaults.activity.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import example.test.kudaybergen.daggerapplicationdefaults.R;
import example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.http.response.Result;

/**
 * Created by Kudaybergen on 24.08.2015.
 *
 * Menu list adapter to init them
 */
public class DataListAdapter extends BaseAdapter{

    private Context context;
    private ViewHolder holder;
    private ArrayList<Result> result;

    public class ViewHolder{
        TextView auto;
        TextView freeSeats;
        TextView LocalityFromName;
        TextView LocalityToName;
        TextView PricePlace;
    }

    public DataListAdapter(Context context, ArrayList<Result> result) {
        this.context = context;
        this.result = result;
    }

    @Override
    public int getCount() {
        return result.size();
    }

    @Override
    public Object getItem(int position) {
        return result.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.view_list_item, null);
            holder = new ViewHolder();
            holder.auto = (TextView) convertView.findViewById(R.id.auto);
            holder.freeSeats = (TextView) convertView.findViewById(R.id.freeSeats);
            holder.LocalityFromName = (TextView) convertView.findViewById(R.id.LocalityFromName);
            holder.LocalityToName = (TextView) convertView.findViewById(R.id.LocalityToName);
            holder.PricePlace = (TextView) convertView.findViewById(R.id.PricePlace);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.auto.setText(result.get(position).getAuto());
        holder.freeSeats.setText(result.get(position).getFreeSeats());
        holder.LocalityFromName.setText(result.get(position).getLocalityFromName());
        holder.LocalityToName.setText(result.get(position).getLocalityToName());
        holder.PricePlace.setText(result.get(position).getPricePlace()+"");

        return convertView;
    }

}
