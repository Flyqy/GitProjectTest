package com.example.liqfo.gitprojecttest.Fragments.Git;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liqfo.gitprojecttest.Activity.WebActivity.WebActivity;
import com.example.liqfo.gitprojecttest.BaseElement.BaseFragment;
import com.example.liqfo.gitprojecttest.Objects.Repos;
import com.example.liqfo.gitprojecttest.R;
import com.example.liqfo.gitprojecttest.Utils.RecyclerItemClickListener;

import java.util.List;

public class GitFragment extends BaseFragment implements GitView {

    private GitPresenter gitPresenter = new GitPresenter();

    private SwipeRefreshLayout srl;
    private RecyclerView rv;
    private ObjectAdapter objectAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setTitle(R.string.public_rep);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gitPresenter.loadGitItems();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.git_fragment_layout, container, false);

        rv = view.findViewById(R.id.rv_git_list);
        rv.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(mLayoutManager);
        objectAdapter = new ObjectAdapter();
        rv.setAdapter(objectAdapter);

        rv.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), rv, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                gitPresenter.onItemClick(objectAdapter.getUrl(position));
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        srl = view.findViewById(R.id.swipe_refresh_layout);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                gitPresenter.loadGitItems();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        gitPresenter.attachView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        gitPresenter.onDestroy();
    }


    @Override
    public void showItems(List<Repos> list) {
        srl.setRefreshing(false);
        objectAdapter.setDataObjects(list);
        objectAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRvItemClick(String url) {
        Intent intent = new Intent(getContext(), WebActivity.class);
        intent.putExtra(WebActivity.URL, url);
        startActivity(intent);
    }
}
