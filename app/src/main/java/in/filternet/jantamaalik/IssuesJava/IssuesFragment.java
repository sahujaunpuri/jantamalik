package in.filternet.jantamaalik.IssuesJava;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import in.filternet.jantamaalik.ItemClickListener;
import in.filternet.jantamaalik.MainActivity;
import in.filternet.jantamaalik.R;

public class IssuesFragment extends android.support.v4.app.Fragment implements ItemClickListener {
    View view;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private List<String> arr;

    private SharedPreferences mSharedPref;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        mSharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());

        String current_language = mSharedPref.getString(MainActivity.sUSER_CURRENT_LANGUAGE, null);
        if(current_language != null && current_language.equals(MainActivity.sLANGUAGE_HINDI)) {
            MainActivity.setUI_Lang(getActivity(), "hi");
        }

        view = inflater.inflate(R.layout.issues_fragment,container,false);
        recyclerView = view.findViewById(R.id.Issues_recyclerview);

        //use a linear layout manager
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
         recyclerView.setHasFixedSize(true);
        //setting the adapter

        arr = new ArrayList<>();
        arr.add(getString(R.string.CrimeIssue));
        arr.add(getString(R.string.IssueUnemployment));
        arr.add(getString(R.string.IssueInflation));
        arr.add(getString(R.string.IssueEducation));
        arr.add(getString(R.string.IssueClimate));
        arr.add(getString(R.string.IssueHealth));
        adapter = new IssuesFragmentRecyclerViewAdapter(arr);
        ((IssuesFragmentRecyclerViewAdapter) adapter).onItemClickListener(this);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onClick(View view, int position) {

        Intent intent = new Intent(view.getContext(), IssuesItem.class);
        startActivity(intent);

    }
}