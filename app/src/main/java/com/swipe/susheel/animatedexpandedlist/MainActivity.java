package com.swipe.susheel.animatedexpandedlist;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    private AnimatedExpandableListView listview;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ExampleAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.app_bar);
        toolbar.setTitle("Cowboy Calculator");
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        listview = (AnimatedExpandableListView)findViewById(R.id.listView);
        List<GroupItem> items = new ArrayList<GroupItem>();

        // Populate our list with groups and it's children
        for(int i = 1; i < 4; i++) {

            if(i==1){
                GroupItem item = new GroupItem();

                item.title = "News Feed";

                ChildItem child1 = new ChildItem();
                child1.title = "Cattle Outlook U. Missouri";
                item.items.add(child1);

                ChildItem child2 = new ChildItem();
                child2.title = "Hog Outlook U. Missouri";
                item.items.add(child2);

                ChildItem child3 = new ChildItem();
                child3.title = "Swine Economics Report U. Missouri";
                item.items.add(child3);

                ChildItem child4 = new ChildItem();
                child4.title = "CME Daily Livestock Report";
                item.items.add(child4);

                ChildItem child5 = new ChildItem();
                child5.title = "Weekly National Grain Market Review";
                item.items.add(child5);

                ChildItem child6 = new ChildItem();
                child6.title = "National Feedstuffs Market Review";
                item.items.add(child6);

                items.add(item);
            }

            if(i==2){
                GroupItem item = new GroupItem();
                item.title = "Future's Market";
                ChildItem child1 = new ChildItem();
                child1.title = "Live Cattle";
                item.items.add(child1);

                ChildItem child2 = new ChildItem();
                child2.title = "Feeder Cattle";
                item.items.add(child2);

                ChildItem child3 = new ChildItem();
                child3.title = "Lean Hog";
                item.items.add(child3);

                ChildItem child4 = new ChildItem();
                child4.title = "Class III Milk";
                item.items.add(child4);

                ChildItem child5 = new ChildItem();
                child5.title = "Corn";
                item.items.add(child5);

                ChildItem child6 = new ChildItem();
                child6.title = "Soybeans";
                item.items.add(child6);

                ChildItem child7 = new ChildItem();
                child7.title = "Soybean Meal";
                item.items.add(child7);

                ChildItem child8 = new ChildItem();
                child8.title = "Oats";
                item.items.add(child8);

                ChildItem child9 = new ChildItem();
                child9.title = "Hard Red Wheat Futures";
                item.items.add(child9);

                items.add(item);
            }

            if(i==3){

                GroupItem item = new GroupItem();
                item.title = "Calculators";
                ChildItem child1 = new ChildItem();
                child1.title = "Cattle Finisher";
                item.items.add(child1);

                ChildItem child2 = new ChildItem();
                child2.title = "Backgrounder";
                item.items.add(child2);

                ChildItem child3 = new ChildItem();
                child3.title = "Stocker";
                item.items.add(child3);

                ChildItem child4 = new ChildItem();
                child4.title = "Cull Feeding/Marketing";
                item.items.add(child4);
                items.add(item);

            }

        }


        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open,R.string.drawer_close){

            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
                invalidateOptionsMenu();
                syncState();
            }

            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
                invalidateOptionsMenu();
                syncState();
            }

        };
        adapter = new ExampleAdapter(this);
        adapter.setData(items);
        listview.setAdapter(adapter);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();


        listview.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                // We call collapseGroupWithAnimation(int) and
                // expandGroupWithAnimation(int) to animate group
                // expansion/collapse.
                if (listview.isGroupExpanded(groupPosition)) {
                    listview.collapseGroupWithAnimation(groupPosition);
                } else {
                    listview.expandGroupWithAnimation(groupPosition);
                }
                return true;
            }

        });




    }

    private static class GroupItem {
        String title;
        List<ChildItem> items = new ArrayList<ChildItem>();
    }

    private static class ChildItem {
        String title;
        String hint;
    }

    private static class ChildHolder {
        TextView title;
        TextView hint;
    }

    private static class GroupHolder {
        TextView title;
    }



    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            String versionName = BuildConfig.VERSION_NAME;

            return true;
        }


        if(id == android.R.id.home){
            if(mDrawerLayout.isDrawerOpen(mDrawerList)){
                mDrawerLayout.closeDrawer(mDrawerList);
            }
            else{
                mDrawerLayout.openDrawer(mDrawerList);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private class ExampleAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {
        private LayoutInflater inflater;

        private List<GroupItem> items;

        public ExampleAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }

        public void setData(List<GroupItem> items) {
            this.items = items;
        }

        @Override
        public ChildItem getChild(int groupPosition, int childPosition) {
            return items.get(groupPosition).items.get(childPosition);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getRealChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ChildHolder holder;
            final ChildItem item = getChild(groupPosition, childPosition);
            if (convertView == null) {
                holder = new ChildHolder();
                convertView = inflater.inflate(R.layout.list_item, parent, false);
                holder.title = (TextView) convertView.findViewById(R.id.textTitle);
                holder.hint = (TextView) convertView.findViewById(R.id.textHint);
                convertView.setTag(holder);
            } else {
                holder = (ChildHolder) convertView.getTag();
            }

            holder.title.setText(item.title);
            holder.hint.setText(item.hint);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(MainActivity.this, String.valueOf(groupPosition) + String.valueOf(childPosition), Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;
        }

        @Override
        public int getRealChildrenCount(int groupPosition) {
            return items.get(groupPosition).items.size();
        }

        @Override
        public GroupItem getGroup(int groupPosition) {
            return items.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return items.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            GroupHolder holder;
            GroupItem item = getGroup(groupPosition);
            if (convertView == null) {
                holder = new GroupHolder();
                convertView = inflater.inflate(R.layout.group_item, parent, false);
                holder.title = (TextView) convertView.findViewById(R.id.textTitle);
                convertView.setTag(holder);
            } else {
                holder = (GroupHolder) convertView.getTag();
            }

            holder.title.setText(item.title);

            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean isChildSelectable(int arg0, int arg1) {
            return true;
        }

    }




}
