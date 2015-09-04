(ns my-project.spec-utils
  (:require [clj-webdriver.taxi :as t]
            [clj-webdriver.driver :as driver]
            [my-project.spec-utils.server :as server]
            [my-project.spec-utils.compiler :as compiler]
            [my-project.spec-utils.phantomjs :as phantomjs]))

(def build-cljs! compiler/build-cljs!)

(defn with-server
  "Start a server to host the js files"
  [specs]
  (println "starting server")
  (let [svr (server/start 10555)]
    (try (specs) (finally (.stop svr)))))

(defn with-webdriver
  "setup selenium webdriver"
  [specs]
  (println "starting webdriver")
  (try
    (let [driver (driver/init-driver {:webdriver (phantomjs/driver)})]
      (t/implicit-wait driver 3000)
      (t/set-driver! driver)
      (specs))
    (finally (t/quit))))
