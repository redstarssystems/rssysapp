(ns clj.new.rssysapp
  (:require [clj.new.templates :refer [renderer project-data ->files]]))

(defn rssysapp
  "entry point to run template."
  [name]
  (let [render (renderer "rssysapp")
        data   (project-data name)]
    (println "Generating project from application template https://github.com/redstarssystems/rssysapp.git")
    (println "See README.adoc in project root to install once project prerequisites.")
    (->files data
      [".clj-kondo/config.edn" (render ".clj-kondo/config.edn" data)]
      ["dev/src/user.clj" (render "dev/src/user.clj" data)]
      ["deps.edn" (render "deps.edn" data)]
      [".gitignore" (render ".gitignore" data)]
      ["resources/log4j2.xml" (render "resources/log4j2.xml" data)]
      ["src/{{nested-dirs}}/core.clj" (render "src/core.clj" data)]
      ["test/{{nested-dirs}}/core_test.clj" (render "test/core_test.clj" data)]
      [".editorconfig" (render ".editorconfig" data)]
      [".env.public" (render ".env.public" data)]
      [".env.private" (render ".env.private" data)]
      [".envrc" (render ".envrc" data)]
      [".cljstyle" (render ".cljstyle" data)]
      ["CHANGELOG.adoc" (render "CHANGELOG.adoc" data)]
      ["LICENSE" (render "LICENSE" data)]
      ["Justfile" (render "Justfile" data)]
      ["tests.edn" (render "tests.edn" data)]
      ["version_id" (render "version_id" data)]
      ["README.adoc" (render "README.adoc" data)]
      ["scripts/bump-semver.clj" (render "scripts/bump-semver.clj" data)]
      ["pom.xml" (render "pom.xml" data)])))
