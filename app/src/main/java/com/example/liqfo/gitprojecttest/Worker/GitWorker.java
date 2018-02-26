package com.example.liqfo.gitprojecttest.Worker;

import com.example.liqfo.gitprojecttest.Network.GitService;
import com.example.liqfo.gitprojecttest.Objects.Repos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GitWorker {

    private List<Repos> responseMe = new ArrayList<>();

    public List<Repos> loadItems(int since){
        GitService service = GitService.retrofit.create(GitService.class);
        final Call<List<Repos>> call = service.getReps(since);

        call.enqueue(new Callback<List<Repos>>() {
            @Override
            public void onResponse(Call<List<Repos>> call, Response<List<Repos>> response) {
                responseMe = response.body();
                //getView().showItems(response.body().get(3).toString());
            }

            @Override
            public void onFailure(Call<List<Repos>> call, Throwable t) {
                responseMe = null;
                //getView().showItems(t.getMessage());
            }
        });

        return responseMe;
    }
}
