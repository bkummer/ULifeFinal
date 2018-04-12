package com.ul.ulife;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class HangoutsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.saved_tabs, null);
        ExpandableListView elv = (ExpandableListView) v.findViewById(R.id.list);
        elv.setAdapter(new SavedTabsListAdapter());
        return v;
    }

    public class SavedTabsListAdapter extends BaseExpandableListAdapter {

        private String[] groups = {"CSIS Building", "Shuman", "Main Building", "The Square"};

        private String[][] children ={{"There is a nice coffee are in the CSIS building where you can relax or do some work."}, {"There are some nice couches on different floors" +
                "in the Shuman building."}, {"There are couches in some of the hallways in the main building or you could grab some food in the food hall."}, {"On nice days you can relax in the sun in the square on the" +
                "stone benches."}};

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int i) {
            return children[i].length;
        }

        @Override
        public Object getGroup(int i) {
            return groups[i];
        }

        @Override
        public Object getChild(int i, int i1) {
            return children[i][i1];
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(HangoutsFragment.this.getActivity());
            textView.setText(getGroup(i).toString());
            textView.setPadding(100, 0, 0, 0);
            textView.setTextColor(Color.BLUE);
            textView.setTextSize(40);
            return textView;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(HangoutsFragment.this.getActivity());
            textView.setText(getChild(i, i1).toString());
            textView.setPadding(100, 0, 0, 0);
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(30);
            return textView;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }

    }

}