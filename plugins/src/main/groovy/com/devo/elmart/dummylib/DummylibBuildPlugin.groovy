package com.devo.elmart.dummylib

import org.gradle.api.initialization.*
import org.gradle.api.*

class DummylibBuildPlugin implements Plugin<Settings> {
  void apply(Settings settings) {
    settings.with {
      pluginManagement {
        repositories {
          maven {
            name "spring-plugins-release"
            url "https://repo.spring.io/plugins-release/"
          }
        }
      }

      rootProject.name = 'dummylib'

      gradle.rootProject {
        apply plugin: 'java-library'

        group "com.devo.elmart"

        println "---- PROJECT ----" + project.name
        println "---- NORMAL REPOS ----" + project.repositories.collect {it.name}
        println "---- PLUGIN MANAGEMENT REPOS ----" + gradle.settings.pluginManagement.repositories.collect {it.name}
      }
    }
  }
}
