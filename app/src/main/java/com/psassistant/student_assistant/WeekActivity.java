package com.psassistant.student_assistant;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.psassistant.student_assistant.Utils.LetterImageView;

public class WeekActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);

        setupUIViews();
        initToolbar();

        setupListView();

    }

    private void setupUIViews(){
     //  toolbar = (Toolbar)findViewById(R.id.ToolbarWeek);
        listView = (ListView) findViewById(R.id.lvWeek);


    }

    private void initToolbar(){
       //setSupportActionBar(toolbar);
       //getSupportActionBar().setTitle("Week");
       //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    //temp

    //temp

    private void setupListView(){
        String[] week = getResources().getStringArray(R.array.Week);
           WeekAdapter adapter = new WeekAdapter(this,R.layout.activity_week_single_item, week);
           listView.setAdapter(adapter);

           //on item click activity

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch(position){
                    case 0:break;
                    case 1:break;
                    case 2:break;
                    case 3:break;
                    case 4:break;
                    case 5:break;
                    default:break;
                }
            }
        });


    }

    public class WeekAdapter extends ArrayAdapter{

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] week = new String[]{};

        public WeekAdapter(Context context, int resource, String[] objects) {
            super(context, resource , objects);
            this.resource = resource;
            this.week = objects;
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null){
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource, null);
                holder.ivLogo = (LetterImageView)convertView.findViewById(R.id.ivLetter);
                holder.tvWeek = (TextView)convertView.findViewById(R.id.tvWeek);    //check on error
                convertView.setTag(holder);
            }
            else {
                holder = (ViewHolder)convertView.getTag();
            }
            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(week[position].charAt(0));
            holder.tvWeek.setText(week[position]);

            return convertView;
        }
        class ViewHolder{
            private LetterImageView ivLogo;
            private TextView tvWeek;
        }
    }

    //for back button purpose
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home : {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
