package com.example.raushan.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView txtview;
    MySQLiteHelper db;
    CustomBaseAdapter ca;
    List<Routes> nm2;
    ListView lst;
    Button bthn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtview=(TextView)findViewById(R.id.txt1);
        lst=(ListView)findViewById(R.id.lstview);
        db= new MySQLiteHelper(this);
        List<Routes> nm2 = db.getAllNames();
        ca = new CustomBaseAdapter(this,R.layout.showdb,nm2);
        lst.setAdapter(ca);
        bthn = (Button)findViewById(R.id.btn);
        bthn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Add.class);
                startActivity(i);
            }
        });
    }
    public class ViewHolder
    {
        TextView fnln;
        Button enrl;

    }
    public class CustomBaseAdapter extends ArrayAdapter<Routes>
    {
        Context context;
        List<Routes> nm2;
        public CustomBaseAdapter(Context context, int resourceId , List<Routes> nitems)
        {
            super(context,resourceId,nitems);
            this.context = context;
            this.nm2=nitems;
        }
        public View getView(int position, View convertView, ViewGroup parent)
        {
            ViewHolder holder = null;
            Routes nm3 = getItem(position);
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if (convertView == null)
            {
                convertView = mInflater.inflate(R.layout.showdb, null);
                holder = new ViewHolder();
                holder.fnln = (TextView) convertView.findViewById(R.id.shwdb);
                holder.enrl = (Button) convertView.findViewById(R.id.enroll);
                convertView.setTag(holder);
            }
            else
            {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.fnln.setText(nm3.getrtno() + " " + nm3.getrtsrc() +" " + nm3.getrtdst() + " " + nm3.getrtpk1() + " " + nm3.getrtpk2());
            final String j = nm3.getrtno() + " " + nm3.getrtsrc() +" " + nm3.getrtdst() + " " + nm3.getrtpk1() + " " + nm3.getrtpk2();
            holder.enrl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Add on student dashboar
                    Intent i = new Intent(MainActivity.this,Login.class);
                    i.putExtra("name",j);
                    startActivity(i);
                }
            });
            return convertView;
        }
    }
}