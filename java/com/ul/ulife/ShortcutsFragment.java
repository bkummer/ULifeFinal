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

/**
 * Pieced together from:
 * Android samples: com.example.android.apis.view.ExpandableList1
 * http://androidword.blogspot.com/2012/01/how-to-use-expandablelistview.html
 * http://stackoverflow.com/questions/6938560/android-fragments-setcontentview-alternative
 * http://stackoverflow.com/questions/6495898/findviewbyid-in-fragment-android
 */
public class ShortcutsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.saved_tabs, null);
        ExpandableListView elv = (ExpandableListView) v.findViewById(R.id.list);
        elv.setAdapter(new SavedTabsListAdapter());
        return v;
    }

    public class SavedTabsListAdapter extends BaseExpandableListAdapter {

        private String[] groups = {"Dromroe Bridge", "President's House", "Main Building"};

        private String[][] children ={{"The bridge by Dromroe can be used to get to and from the student accommodations."}, {"The road by the presidents house can be a quicker way" +
                "to get to the PESS building."}, {"There are multiple entrances to the main building."}};

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
            TextView textView = new TextView(ShortcutsFragment.this.getActivity());
            textView.setText(getGroup(i).toString());
            textView.setPadding(100, 0, 0, 0);
            textView.setTextColor(Color.BLUE);
            textView.setTextSize(40);
            return textView;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(ShortcutsFragment.this.getActivity());
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