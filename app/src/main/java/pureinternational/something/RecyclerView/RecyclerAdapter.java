package pureinternational.something.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pureinternational.something.R;
import pureinternational.something.WebPage;

public class RecyclerAdapter extends  RecyclerView.Adapter<RecyclerAdapter.DataViewHolder>{

    private Context context;
    private List<RecyclerData> dataList;


    public RecyclerAdapter(Context context, List<RecyclerData> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_layout,null);
        DataViewHolder holder = new DataViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final DataViewHolder holder, int position) {
        final RecyclerData RD = dataList.get(position);

        holder.tv1.setText(RD.getText1());
        holder.tv2.setText(RD.getText2());
        holder.tv3.setText(RD.getText3());

        holder.iv.setImageDrawable(context.getResources().getDrawable(RD.getImage()));

        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String text3 =RD.getText3();
                //Toast.makeText(context, RD.getText1(), Toast.LENGTH_SHORT).show();
                //Recycler rc =  new Recycler();
                //rc.address=text3;
                //rc.click();

                //Intent o = new Intent(context, WebPage.class);
                //o.putExtra("WEB_URL",RD.getText3());
                //context.startActivity(o);

                holder.iv.setImageDrawable(context.getResources().getDrawable(R.drawable.akali_splash));

            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class DataViewHolder extends RecyclerView.ViewHolder{


        private ImageView iv;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        public LinearLayout ll;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.textView1);
            tv2 = itemView.findViewById(R.id.textView2);
            tv3 = itemView.findViewById(R.id.textView3);
            iv = itemView.findViewById(R.id.imageView1);
            ll =itemView.findViewById(R.id.linearLayout);
        }
    }
}
