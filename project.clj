(defproject my-project "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.48"]]

  :plugins [[lein-cljsbuild "1.0.6"]]

  :source-paths ["src"]

  :resource-paths ["resources" "resources/public"]

  :aliases {"dev" ["with-profile" "dev" "figwheel" "main"]
            "prod" ["with-profile" "-dev" "cljsbuild" "once" "main"]
            "autospec" ["with-profile" "integration" "spec" "-a"]}

  :cljsbuild
  {:builds
   {:main {:source-paths ["src"]
           :compiler {:output-to "resources/public/out/my_project.js"
                      :optimizations :advanced
                      :main my-project.core
                      :pretty-print false}}}}

  :profiles
  {:dev {:dependencies [[figwheel "0.3.8"]
                        [org.clojure/tools.nrepl "0.2.10"]]
         :plugins [[lein-figwheel "0.3.8"]]

         :cljsbuild
         {:builds
          {:main {:source-paths ["src"]
                  :figwheel {:on-jsload "my-project.core/on-js-reload"}
                  :compiler {:main my-project.core
                             :optimization :none
                             :asset-path "out"
                             :output-to "resources/public/out/my_project.js"
                             :output-dir "resources/public/out"
                             :source-map-timestamp true}}}}

         :figwheel {:css-dirs ["resources/public/css"]}

         :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]}

   :integration {:dependencies [[speclj "3.3.1"]
                                [clj-webdriver "0.6.1"]
                                [compojure "1.3.4"]
                                [ring/ring-jetty-adapter "1.4.0-RC1"]]

                 :plugins [[speclj "3.3.1"]]

                 :test-paths ["src" "spec"]}})
