package computing.mixone.fosdub2017;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.io.File;

/**
 * Created by migue_4arndvd on 06/04/2017.
 */
public class LineUpFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static LineUpFragment newInstance(int sectionNumber) {
        LineUpFragment fragment = new LineUpFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public LineUpFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        container.removeAllViews();
        // Set up our adapter
        ExpandableListAdapter listAdapter = new customListAdapter();


        View rootView = inflater.inflate(R.layout.fragment_line_up, container, false);
        ExpandableListView expLV = (ExpandableListView) rootView.findViewById(R.id.expandableListView);//getExpandableListView();
        expLV.setAdapter(listAdapter);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((HomePage) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
    public class customListAdapter extends BaseExpandableListAdapter {
        // Sample data set.  children[i] contains the children (String[]) for groups[i].
        private String[] groups = { "▬ ▬ Main Stage ▬ ▬\nHigh 'n' Irie crew\n\n♫ Very Special Guests ♫",
                "Tour de Samme Stage\nPowered by BE:PULSED\n\n♫ Hip hop ♫ Electro swing ♫ Jungle ♫ Techno ♫ Minimal ♫ Dubstep ♫" };
        private String[][] children = { {"Omar Perry - Live", "Kandee DUB meet Jahzz - Live & Sax", "Bunzero", "Reservoir DUB ft Soul Skankin'", "Catch My Bass Crew"},
                {"Pneumotracks ft SEKA - Live Scratch & Beatbox\nTDS crew","Global Hybrid Records - Ethno/Techno/Fanfare",
                        "Rastacore - Dub/Jungle/Electroswing\nTDS crew", "Phonetics - Afro-Beat/Dubstep\n54 KOLAKTIV", "DJ SEW - Reggae/Dub/Steppa\nTDS crew",
                "BE:PULSED\n► CRAWL - Techno\n► The DIOUD - Minimal\n► SUBJECTIVE VIBES - Psytrance"}
        };

        public Object getChild(int groupPosition, int childPosition) {
            return children[groupPosition][childPosition];
        }

        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        public int getChildrenCount(int groupPosition) {
            return children[groupPosition].length;
        }

        public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                                 View convertView, ViewGroup parent) {

            TextView textView = new TextView(LineUpFragment.this.getContext());
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            //textView.setBackgroundResource(R.drawable.gradient_big);
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
            textView.setPadding(50, 25, 50, 25);
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(18);
            textView.setText(getChild(groupPosition, childPosition).toString());
            return textView;
        }//getChildView

        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        public int getGroupCount() {
            return groups.length;
        }

        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                                 ViewGroup parent) {
            TextView textView = new TextView(LineUpFragment.this.getContext());
            textView.setBackgroundResource(R.drawable.gradient_big);
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
            textView.setPadding(50, 0, 50, 0);
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(20);
            textView.setText(getGroup(groupPosition).toString());

        /*Button btn = new Button(MLT_File.this);
        btn.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
        btn.setText("Edit");
        btn.setId(100+groupPosition);
        btn.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);

        TableLayout layout = new TableLayout(MLT_File.this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setColumnStretchable(1, true);
        layout.addView(textView);
        //layout.addView(btn);*/

            return textView;
        }

        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        public boolean hasStableIds() {
            return true;
        }

    }//customListAdapter
}