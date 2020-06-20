package pureinternational.something;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Info> {

    // private Context mContext;
    // int mResource;

    public CustomAdapter(Context context, int resource, ArrayList<Info> objects) {
        super(context, resource, objects);
        //  this.mContext = context;
        //mResource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater LF = LayoutInflater.from(getContext());
        View customView = LF.inflate(R.layout.customadapter, parent, false);

        //String string = (String) getItem(position);
        TextView TV1 = customView.findViewById(R.id.adaptertext1);
        TextView TV2 = customView.findViewById(R.id.adaptertext2);
        TextView TV3 = customView.findViewById(R.id.adaptertext3);
        ImageView IV = customView.findViewById(R.id.adapterimage);

        String name = getItem(position).getCharName();
        String skill = getItem(position).getCharSkill();
        String web = getItem(position).getCharWeb();
        int pic = getItem(position).getCharPic();


        //String string = (String) getItem(position);

        TV1.setText(name);
        TV2.setText(skill);
        TV3.setText(web);
        IV.setImageResource(pic);
        return customView;

    }

}



