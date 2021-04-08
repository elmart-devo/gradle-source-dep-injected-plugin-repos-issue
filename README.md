# gradleissue

A showcase of a gradle problem where injecting a plugin into a source dependency
makes so that repositories configured for plugin are ignored.

## Instructions to reproduce problem

- Clone this repo: `git clone https://github.com/elmart-devo/gradleissue.git`.
- Go into cloned dir: `cd gradleissue`
- Check you can build ok: `./gradlew --console verbose build`
- Now edit `plugins/build.gradle` and define a repo and a dependency.
- Build again. It will fail to find the dep, and will report having searched
  only in Gradle Plugin Portal `https://plugins.gradle.org`, ignoring the repo
  you have defined.
- You can also see (though `println` statements included in `build.gradle`
  files), that repos are defined ok in Configuration phase. It's just they are
  ignored when resolving dependencies for the injected plugin.
