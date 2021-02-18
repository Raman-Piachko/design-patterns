package com.epam.rd.autocode.observer.git;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.rd.autocode.observer.git.Event.Type.COMMIT;
import static com.epam.rd.autocode.observer.git.Event.Type.MERGE;

public class GitRepository implements Repository {
    private List<WebHook> webHooks;
    private List<Commit> commits;

    public GitRepository() {
        this.webHooks = new ArrayList<>();
        this.commits = new ArrayList<>();
    }

    @Override
    public void addWebHook(WebHook webHook) {
        webHooks.add(webHook);
    }

    @Override
    public Commit commit(String branch, String author, String[] changes) {
        Commit commit = new Commit(branch, author, changes);
        if (!webHooks.isEmpty()) {
            commits.add(commit);
            webHooks.stream()
                    .filter(webHook -> webHook.type().equals(COMMIT) && webHook.branch().equals(branch))
                    .forEach(webHook -> webHook.onEvent(new Event(COMMIT, branch, Collections.singletonList(commit))));
        }
        return commit;
    }

    @Override
    public void merge(String sourceBranch, String targetBranch) {
        List<Commit> targetBranchCommit = getCommits(sourceBranch, targetBranch);
        if (isMergeWebHook(webHooks)) {
            notifyHooksAboutMerge(targetBranch, targetBranchCommit);
        }
    }

    private List<Commit> getCommits(String sourceBranch, String targetBranch) {
        return commits.stream()
                .filter(commit -> commit.branch().equals(sourceBranch))
                .peek(commit -> commit.setBranch(targetBranch))
                .collect(Collectors.toList());
    }

    private void notifyHooksAboutMerge(String targetBranch, List<Commit> targetBranchCommit) {
        webHooks.stream()
                .filter(webHook -> webHook.type().equals(MERGE) && webHook.branch().equals(targetBranch))
                .forEach(webHook -> webHook.onEvent(new Event(MERGE, targetBranch, targetBranchCommit)));
    }

    private boolean isMergeWebHook(List<WebHook> webHooks) {
        return webHooks.stream()
                .findFirst()
                .filter(webHook -> webHook.type().equals(MERGE))
                .isPresent();
    }
}
