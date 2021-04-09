# gradleissue

A showcase of a gradle problem where injecting a plugin into a source dependency
makes so that repositories configured for plugin are ignored.

## Instructions to reproduce problem

- Clone this repo: `git clone https://github.com/elmart-devo/gradleissue.git`.
- Go into cloned dir: `cd gradleissue`
- Build the project: `./gradlew --console verbose build`
- The build fails with the following message:
  ```
  * What went wrong:
Could not resolve all artifacts for configuration 'classpath'.
> Could not find com.atlassian.activeobjects:activeobjects-confluence-spi:3.3.1..
  Searched in the following locations:
    - https://plugins.gradle.org/m2/com/atlassian/activeobjects/activeobjects-confluence-spi/3.3.1./activeobjects-confluence-spi-3.3.1..pom
  If the artifact you are trying to retrieve can be found in the repository but without metadata in 'Maven POM' format, you need to adjust the 'metadataSources { ... }' of the repository declaration.
  Required by:
      unspecified:unspecified:unspecified > project :plugins
  ```
  There, it can be seen the defined repo was not searched, and Gradle Plugin
  Portal was searched instead.
