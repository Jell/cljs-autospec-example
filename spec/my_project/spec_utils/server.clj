(ns my-project.spec-utils.server
  (:require [clojure.java.io :as io]
            [compojure.core :refer [routes GET defroutes]]
            [compojure.route :refer [resources]]
            [compojure.handler :refer [api]]
            [ring.adapter.jetty :refer [run-jetty]]))

(defroutes http-handler
  (GET "/out/my_project.js" []
    (io/resource "integration/my_project.js"))
  (GET "/" []
    (io/resource "index.html"))
  (resources "/" :root "resources/public"))

(defn start [port]
  (run-jetty http-handler {:port port :join? false}))
