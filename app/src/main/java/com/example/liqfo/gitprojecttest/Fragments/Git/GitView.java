package com.example.liqfo.gitprojecttest.Fragments.Git;

import com.example.liqfo.gitprojecttest.BaseElement.BaseView;
import com.example.liqfo.gitprojecttest.Objects.Repos;

import java.util.List;

public interface GitView extends BaseView{

    void showItems(List<Repos> list);

    void onRvItemClick(String url);

}
