# TaskManager
Scalable project in Springboot/Java

Git learning:

| Command             | Removes commit from history? | Removes code from editor? | Creates new commit? |
| ------------------- | ---------------------------- | ------------------------- | ------------------- |
| `git reset --soft`  | YES                          | NO                        | NO                  |
| `git reset --mixed` | YES                          | NO                        | NO                  |
| `git reset --hard`  | YES                          | YES                       | NO                  |
| `git revert`        | NO                           | YES (reverse_PATCH)       | YES                 |

| Command                                  | What happens to Git history?                      | What happens to code in editor? | What happens to staging area? | Safe for pushed commits? | Ideal use case                          |
| ---------------------------------------- | ------------------------------------------------- | ------------------------------- | ----------------------------- | ------------------------ | --------------------------------------- |
| **git reset --soft <commit>**            | Commits after `<commit>` are removed from history | Code remains exactly as it was  | **Changes stay staged**       | ❌ No                     | Fix wrong commit message; merge commits |
| **git reset --mixed <commit>** (default) | Same — commits removed                            | Code stays                      | **Staging cleared**           | ❌ No                     | Undo commit but continue working        |
| **git reset --hard <commit>**            | Commits removed                                   | **Code deleted (rewound)**      | Staging cleared               | ❌ No (dangerous)         | Return project to past version          |
| **git revert <commit>**                  | History stays (adds a new commit)                 | **Undo changes in editor**      | Auto staged → committed       | ✔️ Yes                   | Undo a pushed commit safely             |


