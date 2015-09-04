(ns my-project.spec-utils.compiler
  (:require [cljs.build.api]))

(defn build-cljs!
  "Builds cljs for integration specs"
  []
  (println "building cljs")
  (cljs.build.api/build
   "src"
   {:main 'my-project.core
    :output-to "resources/public/integration/my_project.js"
    :output-dir "resources/public/integration"
    :asset-path "integration"
    :optimizations :none
    :static-fns true ; for phantomjs/safari
    }))
