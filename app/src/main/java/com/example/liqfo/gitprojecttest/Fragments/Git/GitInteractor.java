package com.example.liqfo.gitprojecttest.Fragments.Git;

import com.example.liqfo.gitprojecttest.Objects.Repos;
import com.example.liqfo.gitprojecttest.Worker.GitWorker;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public class GitInteractor {

    public static GitInteractor getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private GitWorker gitWorker;

    public static class InstanceHolder {
        private static final GitInteractor INSTANCE = new GitInteractor();
    }

    private GitInteractor() {
        gitWorker = new GitWorker();
    }

    public Single<List<Repos>> loadItems(final int since){
        return Single.create(new SingleOnSubscribe<List<Repos>>() {
            @Override
            public void subscribe(SingleEmitter<List<Repos>> emitter) throws Exception {
                List<Repos> rs = gitWorker.loadItems(since);
                emitter.onSuccess(rs);
            }
        });
    }

}
