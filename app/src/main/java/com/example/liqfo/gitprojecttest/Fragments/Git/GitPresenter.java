package com.example.liqfo.gitprojecttest.Fragments.Git;

import com.example.liqfo.gitprojecttest.BaseElement.BasePresenter;
import com.example.liqfo.gitprojecttest.Network.GitService;
import com.example.liqfo.gitprojecttest.Objects.Repos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GitPresenter extends BasePresenter<GitView> {

    private GitInteractor gitInteractor;
    private int since = 364;

    public GitPresenter() {
        gitInteractor = GitInteractor.getInstance();
    }

    public void loadGitItems() {
        GitService service = GitService.retrofit.create(GitService.class);
        final Call<List<Repos>> call = service.getReps(since);

        call.enqueue(new Callback<List<Repos>>() {
            @Override
            public void onResponse(Call<List<Repos>> call, Response<List<Repos>> response) {
                getView().showItems(response.body());
            }

            @Override
            public void onFailure(Call<List<Repos>> call, Throwable t) {
                getView().showError(t.getMessage());
            }
        });
    }

    public void onItemClick(String url){
        if (getView() != null){
            getView().onRvItemClick(url);
        }
    }

}
